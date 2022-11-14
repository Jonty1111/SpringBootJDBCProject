package com.spring.boot.jdbc.SpringBootJDBCProject.ServiceLayer;

import com.spring.boot.jdbc.SpringBootJDBCProject.Entity.Player;
import com.spring.boot.jdbc.SpringBootJDBCProject.ErrorResponse.PlayerNotFoundException;
import com.spring.boot.jdbc.SpringBootJDBCProject.Repository.PlayerRepository;
import com.spring.boot.jdbc.SpringBootJDBCProject.Repository.PlayerSpringDataRepository;
import org.apache.el.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerSpringDataRepository repo;

    //getAllPlayers
    public List<Player> getAllPlayers(){
        return repo.findAll();
    }
    //findbyid
    //http://localhost:8060/{"jonty"}
    public Player findPlayerById(@PathVariable("id") int id)//we are trying to say to string that
    {
        Optional<Player> tempPlayer=repo.findById(id);
        //repo.getOne(id); ->Deprecated

        Player p=null;
        if(tempPlayer.isPresent())
            p=tempPlayer.get();
        else {
            throw new PlayerNotFoundException("Player With ID: " + id + " Not Found");
            //throw new RuntimeException("Player with id : " + id + "Not found");

        }
        return p;
    }

    //Add player(POST)

    public Player addPlayer(Player player)
    {
        return repo.save(player);
    }
    // update player(put) --> written by arjun not working
    /*
    public Player updatePlayerByID(@PathVariable("id") int id , Player player)
    {
        Optional<Player> tempPlayer =repo.findById(id);
            Player p = null;
        if(tempPlayer.isEmpty()) {
            throw new RuntimeException("Player with ID" + id + " not found");
        }
        return repo.save(player);
    }*/


    //update Player(PUT REQUEST)
    //Given By Abhimanyu(Logic)(Working fine)
    public Player updatePlayerById(int id, Player player) {
        Optional<Player> optionalPlayer = repo.findById(id);
        if(!optionalPlayer.isEmpty()){
            Player dbPlayer = optionalPlayer.get();
            dbPlayer.setAge(player.getAge());
            dbPlayer.setName(player.getName());
            dbPlayer.setDob(player.getDob());
            dbPlayer.setNationality(player.getNationality());
            dbPlayer.setDesignation(player.getDesignation());
            return repo.save(dbPlayer);
        }else {
            throw new PlayerNotFoundException("Player with id : "+id+" is not present...");
            //throw new RuntimeException("Player with id : " + id + "Not found");

        }
    }
    //Update Partial Patch

    public Player patchPlayerById(@PathVariable("id") int id, Map<String,Object> partialPlayer)
    {
        //Optional is used to capture null pointer exception if present
        Optional<Player> tempPlayer =repo.findById(id);
        if(tempPlayer.isPresent())
        {
            //Itterate through map and make desired changes in player object
            partialPlayer.forEach((Key,value)->{
                System.out.println("KEY IS: " + Key+ " Value IS:  " + value);
                //find field -> finds the fields of an object(class,key(attribute))-> returns field object
                Field field= ReflectionUtils.findField(Player.class,Key);//field object
                ReflectionUtils.makeAccessible(field);//make the private variable in use(Toggles in use (Toggles))

                if(Key=="dob") ReflectionUtils.setField(field, tempPlayer.get(), Date.valueOf((String) value));
                else ReflectionUtils.setField(field, tempPlayer.get(), value); // set the field with the updated/ patched data


                //ReflectionUtils.setField(field,tempPlayer.get(),value);
            });
        }
        else{
            throw new PlayerNotFoundException("Player with id : " + id + "Not found");
//throw new RuntimeException("Player with id : " + id + "Not found");

        }
        return repo.save(tempPlayer.get());
    }


    //Partial Update(using Queries/Entity)
    @Transactional
    public void updateNationality(@PathVariable("id")int id,String nat)
    {
        Optional<Player> tempPlayer =repo.findById(id);
        if(!tempPlayer.isPresent()){
            throw new PlayerNotFoundException("Player with id : " + id + "Not found");
            //throw new RuntimeException("Player with id : " + id + "Not found");

        }
        repo.updateNationality(id,nat);

    }

    //delete operations

    public void deletePlayer(int id)
    {
        Optional<Player> tempPlayer=repo.findById(id);
        if(tempPlayer.isEmpty())throw new PlayerNotFoundException("Player with id : " + id + "Not found");
//throw new RuntimeException("Player with id : " + id + "Not found");

        repo.delete(tempPlayer.get());

    }

}

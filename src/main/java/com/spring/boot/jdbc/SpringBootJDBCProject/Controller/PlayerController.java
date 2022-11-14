package com.spring.boot.jdbc.SpringBootJDBCProject.Controller;

import com.spring.boot.jdbc.SpringBootJDBCProject.Entity.Player;
import com.spring.boot.jdbc.SpringBootJDBCProject.DAO.PlayerDAO;
import com.spring.boot.jdbc.SpringBootJDBCProject.ServiceLayer.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PlayerController {
    //@Autowired
    //PlayerDAO dao;
    @Autowired
    PlayerService service;
/*
    public List<Player> getALlPlayerdb()
    {
        return dao.getAllPlayers();
    }
    @GetMapping("/players-json")
    public List<Player> getAllPlayerFromDBJson()
    {
        return getALlPlayerdb();
    }
*/
   // @GetMapping("/players-json")
    //public List<Player> getAllPlayerFromDBJson()
    //{
   //     return dao.getAllPlayers();
   // }
   /*
    @GetMapping("/playerByID")
    public Player getPlayerbyID()
    {
        return dao.ge
    }
    */
@GetMapping("/players-json")
public List<Player> getALlPlayerData()
{
    return service.getAllPlayers();
}
    @GetMapping("/welcome")
    public String welcome()
    {
        return "Welcome to Player Entity";
    }
    @GetMapping("/player/{id}")
    public Player getPlayer(@PathVariable int id)
    {
        return service.findPlayerById(id);
    }

    @PostMapping("/addPlayer")
    //@RequestMapping(method=RequestMethod.POST)
    public Player addPlayer(@RequestBody Player p)
    {
        p.setId(2);
        return service.addPlayer(p);
    }

    @PutMapping("/updatePlayer/{id}")
    public Player updatePlayer(@PathVariable int id,@RequestBody Player p)
    {
        return service.updatePlayerById(id,p);
    }

    @PatchMapping("/patchplayer/{id}")
    public Player patchPlayer(@PathVariable int id,@RequestBody Map<String,Object> playerPatch)
    {
        return service.patchPlayerById(id,playerPatch);
    }
    //updateing with query (only for nationality)
    @PatchMapping("/patchplayer/{id}/nationality")
    public void patchNationalityById(@PathVariable int id,@RequestBody String nat)
    {
         service.updateNationality(id,nat);
    }


    //Delete Operations
    @DeleteMapping("/deletePlayer/{id}")
    public void deletePlayer(@PathVariable int id)
    {
        service.deletePlayer(id);
    }




}

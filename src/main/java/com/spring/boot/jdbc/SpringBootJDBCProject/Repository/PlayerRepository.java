package com.spring.boot.jdbc.SpringBootJDBCProject.Repository;

import com.spring.boot.jdbc.SpringBootJDBCProject.Entity.Player;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

//jpa - java persistance api(jpa based repository)
@Repository // To perform all the crud operations
@Transactional//to make transactions b/w java classes and databases

public class PlayerRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Player insertPlayer(Player player)
    {
        return entityManager.merge(player);
    }

    public Player updatePlayer(Player player){
        return entityManager.merge(player);
    }
    public Player getPlayerById(int id)
    {
        return entityManager.find(Player.class,id);
    }
    //Delete
    public void deleteById(int id)
    {
        Player player = entityManager.find(Player.class,id);
        entityManager.remove(player);
    }
    //GetAllPlayer
    public List<Player> getAllPlayers()
    {
        TypedQuery<Player> getAll = entityManager.createNamedQuery("get_all_players", Player.class);
        return getAll.getResultList();
    }
}

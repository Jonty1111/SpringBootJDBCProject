package com.spring.boot.jdbc.SpringBootJDBCProject.DAO;

import com.spring.boot.jdbc.SpringBootJDBCProject.Entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
//jdbc template based repo
//This was used for SQL Based Operations(Using jdbc template)
@Repository
public class PlayerDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Player> getAllPlayers()
    {
        String getPlayerQuery="SELECT * FROM Player";

        //JDBCTemplate -> Query -> database -> Result Set -> Row Mapped -> Player.class -> List<Object>
        //return jdbcTemplate.query(getPlayerQuery,new BeanPropertyRowMapper<Player>(Player.class));
        return jdbcTemplate.query(getPlayerQuery,new PlayerMapper());

    }
    /*public List<Player> getAllPlayers()
    {
        String getPlayerQuery="SELECT * FROM Player";
        return jdbcTemplate.query(getPlayerQuery,new BeanPropertyRowMapper<Player>(Player.class));

        //JDBCTemplate -> Query -> database -> Result Set -> Row Mapped -> Player.class -> List<Object>
      //  return jdbcTemplate.query(getPlayerQuery,new PlayerMapper());

    }*/
    /* Written by Me
    public Player getPlayerByID(int id)
    {
        String getPlayerByIdQuery ="select * from Player where ID=? ";

        //JDBCTemplate -> Query -> ID is being substituted as a Primary Key -> database -> Result Set -> Row Mapped -> Player.class -> List<Object>
        return jdbcTemplate.queryForObject(getPlayerByIdQuery,new BeanPropertyRowMapper<Player>(Player.class),new Object[]{id});
    }*/
    //By Kalyan
    /*public Player getPlayerbyID(int id)
    {
        String getPlayerbyIDQuery = "SELECT * FROM Player WHERE ID = ?";
        // using JDBCTemplate ==>
        return jdbcTemplate.queryForObject(getPlayerbyIDQuery, new BeanPropertyRowMapper<Player>(Player.class) , new Object[]{id});

    }*/

    // By Abhimanyu Read get by id
    public Player getPlayerById(int id){
        String getAllPlayerQuery = "SELECT * FROM PLAYER WHERE id = ?";
        return jdbcTemplate.queryForObject(getAllPlayerQuery, new BeanPropertyRowMapper<Player>(Player.class), new Object[]{id});
    }
    public int insertPlayer(Player player)
    {
        String insertPlayerQuery="Insert into Player values(?,?,?,?,?,?)";
        return jdbcTemplate.update(insertPlayerQuery,new Object[]{player.getId(),player.getName(),player.getAge(),
                player.getNationality(),new Timestamp(player.getDob().getTime()),player.getDesignation()});

    }

    //Update Player

    public int updatePlayerInfo(Player player){
        String updateQuery = "UPDATE Player "+" SET Name = ?, Age = ?, Nationality = ?, DOB = ?, Designation = ?"+
                "WHERE ID = ?";

        return jdbcTemplate.update(updateQuery, new Object[]{player.getName(), player.getAge(), player.getNationality(),
                new Timestamp(player.getDob().getTime()), player.getDesignation(), player.getId()});

    }

    // Delete Operations on a row
    public int deletePlayer(int id)
    {
        String deleteQuery="Delete FROM Player "+" where ID=?";
        return jdbcTemplate.update(deleteQuery,new Object[]{id});
    }
    private static final class PlayerMapper implements RowMapper {

        @Override
        public Object mapRow(ResultSet rs,int rowNum) throws SQLException{
            Player player=new Player();
            player.setId(rs.getInt("ID"));
            player.setName(rs.getString("Name"));
            player.setAge(rs.getInt("Age"));
            player.setNationality(rs.getString("Nationality"));
            player.setDob(rs.getDate("DOB"));
            player.setDesignation(rs.getInt("Designation"));
            return player;

        }
    }
}

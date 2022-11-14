package com.spring.boot.jdbc.SpringBootJDBCProject;

import com.spring.boot.jdbc.SpringBootJDBCProject.Entity.Player;
import com.spring.boot.jdbc.SpringBootJDBCProject.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.sql.Date;

@SpringBootApplication
public class SpringBootJdbcProjectApplication implements CommandLineRunner {


	@Autowired
	//PlayerDAO dao;
	PlayerRepository repo;
	@Override
	public void run(String... args) throws Exception {
	/*	System.out.println("----------Get EACH PLAYER INFO--------------");
		System.out.println(dao.getAllPlayers());
		System.out.println("----------GET PLAYER BY ID----------\n");
		//System.out.println(dao.getPlayerByID(2));
		System.out.println(dao.getPlayerById(3));
		System.out.println("----------INSERT PLAYER----------\n");
		System.out.println(dao.insertPlayer(new Player(12,"JS7",30,"IND",new Date(System.currentTimeMillis()),4)));
		System.out.println("----------updated data-------");
		System.out.println(dao.getAllPlayers());
		System.out.println("----------Updating a player info ----------\n");
		System.out.println(new Player(12,"JS7",301,"IND",new Date(System.currentTimeMillis()),4));
		System.out.println("After Updating player info ");
		System.out.println(dao.getAllPlayers());

		System.out.println("-------Deleting a player-------------");
		//System.out.println(dao.deletePlayer(12));
		System.out.println(dao.getAllPlayers());
*/













		// Commenting for Tennis purpose only
		//Create
		repo.insertPlayer(new Player("JONTYlatest",19,"AUS",Date.valueOf("2001-01-01"),4));
		repo.insertPlayer(new Player("JONTY1",20,"CANADA",Date.valueOf("2001-01-01"),4));
		repo.insertPlayer(new Player("JONTY2",21,"IND",Date.valueOf("2001-01-01"),4));
		//repo.updatePlayer(new Player(1,"JONTY2",21,"Pak",Date.valueOf("2001-01-01"),4));
		//Read
		//System.out.println(repo.getPlayerById(2));

		//Update
		//repo.updatePlayer(new Player(1,"JONTY2",21,"Pak",Date.valueOf("2001-01-01"),4));

		//delete
		//repo.deleteById(1);
		System.out.println("--------------------getAllPlayers--------------------");

		System.out.println(repo.getAllPlayers());



	}

	//use command line runner where we use the terminal
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcProjectApplication.class, args);
	}

}

package com.spring.boot.jdbc.SpringBootJDBCProject;

import com.spring.boot.jdbc.SpringBootJDBCProject.Entity.Player;
import com.spring.boot.jdbc.SpringBootJDBCProject.Repository.PlayerSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class TennisPlayerSpringDataApplication implements CommandLineRunner {

    @Autowired
    PlayerSpringDataRepository repos;

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... args) throws Exception {

        logger.info("\n Inserting a Player \n",repos.save(new Player("abhi",20,"CANADA", Date.valueOf("2001-01-01"),4)));

        logger.info("\n Inserting a Player \n",repos.save(new Player("kalya",26,"INDIA", Date.valueOf("2001-01-01"),5)));

        logger.info("\n Finding the player by ID \n", repos.findById(1));
        logger.info("\n Finding the player by ID \n", repos.findById(2));

        logger.info("\nDelete By ID \n");
        //repos.deleteById(2);

        logger.info("\n Find all Method \n",repos.findAll());

        //logger.info("\nDelete By ID \n" , repos.deleteById(2));

    }
        public static void main(String[] args) {
            SpringApplication.run(TennisPlayerSpringDataApplication.class, args);
        }

}

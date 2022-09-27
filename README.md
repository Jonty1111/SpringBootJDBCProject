CLIENT -> BROWSER -> REQUEST -> http://localhost:8080/movies -> GET

TOMCAT SERVER -> 127.0.01:8080 -> SpringBootJDBCApp -> Class -> @SpringBootApplication

SpringBootJDBCApp -> @ComponentScan -> Player Controller @RestController[Bean] -> Default Constructor -> Autowired Player DAO

PlayerDAO.getAllPlayer() -> Communicate with the database using (@AutoWired) JDBC Template -> Querying,RowMapping [Player
Model] DAO ->

JPA
---
->No Row Mapper

->No Schema.sql

@Repository
@Entity -> Table -> In Database -> Hibernate Core Will Drop in the database and create new one -> @Column,@Id -> COlumns inside our database
@Entity2
@Entity3
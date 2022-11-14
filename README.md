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












HTTP -> Hyper Text Transfer Protocol

Hypermedia information, Colloborative Media -> TCP Connection by default on PORT 80

Stateless -> No Particular Form -> HTML,JSON,XML,PDF,PNG,PEG -> Data Exchange

Stateful -> restFul API -> JSON, XML -> Proper Form

URL + HTTP + Restful API

URL: Location your server -> 192.168.8.8-8080 -> Flipkart.com

HTTP: TCP by 80 -> Stateless -> Data Exchange btw your server and client

Restful API -> Representational State Transfer -> It should make sense



Client and Server
Browser App <=> Spring Boot App
URL + HTTP + RestFul API(JSON,XML)
Weather App -> Client -> Request Temperature of Mumbai -> Weather Data its raining -> JSON DATA
GoogleMaps -> Server -> Response Temperature of Mumbai 

Location : Mumbai
Temperature : 80 celsius

HTTP Request Message 

*****************************

Request Line -> Contains HTTP Method like (Get,Post,Put,Delete)

Request Header -> Data with additional information about the request you are passing -> configuration for your  request line

Request body -> Content of teh entity player



CLient

Request Line => http://localhost:3000/add-todo + POST Method

Request Header => Content Type => Application/JSON

Request Body => { "todoName": "Spring API", "todoDescription": "Spring API Representation", "id": 1 }

Server

Response Line => http://localhost:3000/add-todo + POST Method

Response Header access-control-allow-origin →* connection →keep-alive content-length →119 content-type →application/json; charset=utf-8 date →Wed, 28 Sep 2022 05:25:41 GMT etag →W/"77-GK4wpj1Vv1Ho5AHfUOXxsHhTdA0" keep-alive →timeout=5 x-powered-by →Express

Response Body/Message { "id": 1, "todoName": "Spring API", "todoDescription": "Spring API Representation", "_id": "6333dad5a2d5136faf28489b", "__v": 0 }

REST -> [https://drive.google.com/file/d/1Jpdv77XTyuGgAbOkfHniEOO14I2vI4l-/view?usp=sharing]

HTTP Methods

POST => CREATING A RESOURCE => h2Database testdb
GET => READING A RESOURCE => h2Database:testdb
PUT => UPDATING A RESOURCE => h2Database:testdb
DELETE => DELETING A RESOURCE=> h2Database:testdb
PATCH->Updating certain attribute of a resource


REST APPS

JSON Data Binding
{
    "key":value
}
->Different apps exchange data

we are going to send all your player based entity 

### ->Jackson Dependency -> POJO(Plain old java object)->converted ->JSON DATA BINDING
# Player Entity

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getDesignation() {
        return designation;
    }

    public void setDesignation(int designation) {
        this.designation = designation;
    }




//////////////

Exceptional Handling -> [https://drive.google.com/file/d/1EoTugnH8_29jMweFOvcLHZgYi3zc7GsD/view?usp=sharing]

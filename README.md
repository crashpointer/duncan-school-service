# Duncan's School Service
This script is used to follow the service vehicles.

## Requirements
Java 1.8 <br />
Maven <br />
PostgreSQL 9.4+

## Dependency
spring-boot-starter-web <br/>
spring-boot-starter-security <br />
spring-boot-starter-thymeleaf <br />
spring-boot-starter-data-jpa

### Database Configuration
cd src/main/resources/ <br />
nano application.properties <br />
You can change your database information <br />
spring.datasource.url=jdbc:postgresql://localhost:5432/duncan <br />
Then you should import the duncan.sql file to your database

### Run with maven
mvn spring-boot:run

### Create executable jar file
mvn clean package

#### Test project
Click the http://localhost:8080 <br />
Then go to register page
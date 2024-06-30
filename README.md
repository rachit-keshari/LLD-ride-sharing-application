# Ride-Sharing App

This is a ride-sharing application built using Spring Boot, H2 in-memory database, and JPA repositories. The application allows users to offer rides, select rides, and manage vehicles.

## Low-Level Design

### Components

1. **UsersService**: Manages user-related operations like adding new users.
2. **VehicleService**: Manages vehicle-related operations like adding new vehicles for users.
3. **RideService**: Manages ride-related operations like offering and selecting rides.

### Driver Class

The `Driver` class initializes the application with some sample data and demonstrates the functionality of the services.

```java
@Service
public class Driver {
    @Autowired
    private UsersService usersService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private RideService rideService;

    public void start() {
        usersService.add_user("Rohan", "M", 36);
        vehicleService.add_vehicle("Rohan", "Swift", "KA-01-12345");
        // Additional initialization and usage of services...
    }
}
```
##JPA Repositories
JPA repositories are used to perform CRUD operations on the database entities. Spring Data JPA simplifies the data access layer by providing built-in implementations of common data access patterns.

###Example Repository
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods can be added here
}
```

##Dependencies
The project uses the following dependencies:

Spring Boot Starter Data JPA: To work with JPA repositories.
Spring Boot Starter Web: To create RESTful web services.
H2 Database: In-memory database for development and testing purposes.
Lombok: To reduce boilerplate code.

##Configuration
###H2 Database Setup
The H2 in-memory database is configured in the application.properties file:

```yaml
spring.application.name=ride-sharing

spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true

hibernate.show_sql=true
hibernate.format_sql=true
```

spring.datasource.url: Specifies the JDBC URL for the H2 database.
spring.datasource.driverClassName: Specifies the driver class name for H2.
spring.datasource.username and spring.datasource.password: Credentials for the H2 database.
spring.jpa.database-platform: Specifies the dialect for H2.
spring.jpa.hibernate.ddl-auto: Specifies the DDL mode (update in this case).
spring.h2.console.enabled: Enables the H2 console for debugging.
hibernate.show_sql and hibernate.format_sql: Configures Hibernate to show and format SQL queries in the logs.

You can access the H2 console at http://localhost:8080/h2-console with the configured JDBC URL jdbc:h2:mem:testdb.

##Relevant Section of `pom.xml`

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

##Usage
After starting the application, the Driver class will initialize some sample data. You can use the provided services to offer rides, select rides, and manage users and vehicles.

```
rideService.offer_ride("Rohan", "Hydrabad", 1, "Swift", "KA-01-12345", "Bangalore", "25th Jan, 2019 08:00", "13 hrs");
rideService.select_ride("Nandini","Bangalore","Mysore", SelectStrategy.FASTEST_RIDE);
```



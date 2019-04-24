# Tom Pet House

A web-app for dog grooming online business, users can register by email 
and appoint services online. Groomer can look up the orders in advance.

## Before Start

### Front-end
It's a full-stack project. Front-end is constructed by HTML, CSS and Javascript. Foundation is 
employed to simplify the development. All the CSS and js code are included in the static folder 
and HTML pages are included in the templates for being rendered.

### Back-end
Spring boot and corresponding modules are used.The main three parts:
* Controller: receives and sends request to browser by invoking services provided by Service layer;

* Service: provides services to controller and access database, between Controller layer and DAO layer;

* DAO: accesses data set and provides data to Service layer.

## Getting Started

These instructions will give you a general idea of the project's architecture 
and running on your local machine for testing and developing further. 


### Run Environment

Maven is employed and you should prepare in the pom.xml:

1.Spring Boot

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.2.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

2.Thymeleaf

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>

3.Web Module

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
4.Database Related (MySQL,Jpa,jdbc)

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>


## Authors
    
* **The Planet Earth** - *Rena, Sergey, Sherry, Karl* 


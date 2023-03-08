# Yoword

Yoword is a web application.  
Here is the backend of application build using Spring Boot, Spring Security, Spring Data JPA with PostgreSQL, Spring MVC. Spring Security with JWT is used for user authentication.  

> Currently it only allow users to share posts and comment.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purpose

### Prerequisites

- Java 8 or later
- Spring Boot 2.x
- Maven 3.x
- PostgreSQL

### Installing

1. Clone the repository

```bash
git clone https://github.com/mehuljain91/yoword.git
```

2. Change directory

```bash
cd yoword
```

3. Build with maven

```bash
maven clean install
```

4. Run the application

```bash
mvn spring-boot:run
```

### Configuration

You need to configure your PostgreSQL database connection in the application.properties file.

## Built with:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)
- [PostgreSQL](https://www.postgresql.org/)

## Additional Notes

The project is currently in development stage, and more features will be added in the future updates.

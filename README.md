# Job Tracker — Backend

REST API backend for Job Application Tracker built with Spring Boot.

## Features
- JWT Authentication (Login/Signup)
- BCrypt Password Encryption
- CRUD Operations for Job Applications
- User-wise data management
- CORS Configuration
- Spring Security

## Tech Stack
- Java 17
- Spring Boot 3.2.5
- Spring Security
- Spring Data JPA
- MySQL
- JWT (jjwt 0.11.5)
- Maven

## Setup

1. Create MySQL database:
```sql
CREATE DATABASE jobtracker_db;
```

2. Update `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jobtracker_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```

3. Run the project:
```bash
mvn spring-boot:run
```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/auth/signup | Register user |
| POST | /api/auth/login | Login user |
| GET | /api/applications/user/{id} | Get user applications |
| POST | /api/applications | Add application |
| PUT | /api/applications/{id} | Update application |
| DELETE | /api/applications/{id} | Delete application |

## Frontend Repo
https://github.com/Sameer99Pro/job-tracker-frontend

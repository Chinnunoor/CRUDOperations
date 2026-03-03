# Spring Boot CRUD Application

A complete enterprise-style CRUD REST API built using Spring Boot, Spring Data JPA, and MySQL.  
This project demonstrates layered architecture, entity relationships, validation, exception handling, and RESTful API design.

---

## Features

- Full CRUD APIs (Create, Read, Update, Delete)
- RESTful architecture (Controller → Service → Repository)
- Entity relationships:
  - One-to-One (Person ↔ Passport)
  - One-to-Many (Person → Addresses)
  - Many-to-Many (Person ↔ Skills)
- Request validation using Jakarta Validation
- Global exception handling
- Structured logging
- MySQL database integration
- Tested with Postman

---

## Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Maven
- Lombok
- Postman

---

## Project Structure


Code

---

## 🔗 Entity Relationships

- **Person → Passport** : One-to-One  
- **Person → Addresses** : One-to-Many  
- **Person → Skills** : Many-to-Many  

---

## API Endpoints

### Person APIs

| Method | Endpoint | Description |
|--------|---------|------------|
POST | `/persons` | Create person |
GET | `/persons` | Get all persons |
GET | `/persons/{id}` | Get person by id |
PUT | `/persons/{id}` | Update person |
DELETE | `/persons/{id}` | Delete person |

(Similar APIs exist for Address, Passport, Skill)

---

## Validation

Examples:

- First name required
- Last name required
- DOB must be past
- Phone must be 10 digits
- Passport number required

Invalid input → **400 Bad Request**

---

## Exception Handling

Custom exception:

```java
PersonNotFoundException


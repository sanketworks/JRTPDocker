# JRTP701 Mini Project 01 – Travel Plan Management API

A Spring Boot REST API for managing travel plans and plan categories.

This project provides CRUD operations for travel plans, including creating, updating, retrieving, deleting, and changing travel plan status. It is built using Spring Boot, Spring Data JPA, Maven, and Oracle/relational database integration.

---

## Features

### Travel Plan Management

- Register a new travel plan
- Get all travel plans
- Find travel plan by ID
- Update travel plan details
- Delete travel plan
- Change travel plan active/inactive status

### Plan Categories

- Fetch all travel plan categories

### Additional Features

- Externalized messages using YAML configuration
- RESTful API design
- JPA/Hibernate persistence
- Automatic timestamp handling
- Clean layered architecture

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- Oracle Database / Relational DB
- Lombok
- Eclipse IDE / STS

---

## Project Structure

```text
src/main/java
└── com.nt
    ├── config
    │   └── AppConfigProperties.java
    │
    ├── constants
    │   └── TravelPlanConstants.java
    │
    ├── entity
    │   ├── PlanCategory.java
    │   └── TravelPlan.java
    │
    ├── ms
    │   └── TravelPlanOperationsController.java
    │
    ├── repository
    │   ├── IPlanCategoryRepository.java
    │   └── ITravelPlanRepository.java
    │
    └── service
        ├── ITravelPlanMgmtService.java
        └── TravelPlanMgmtServiceImpl.java

src/main/resources
├── application.properties
└── application.yml
```

---

## API Base URL

```text
http://localhost:4041/travelplan/api
```

(Port may change based on your configuration)

---

## REST API Endpoints

### Get categories

```http
GET /categories
```

Response:

```json
{
  "1": "Domestic",
  "2": "International"
}
```

---

### Register new travel plan

```http
POST /register
```

Request:

```json
{
  "planName": "USA-10N/9D",
  "planMinBudget": 460000,
  "planDescription": "USA travel package",
  "planCategoryId": 2,
  "createdBy": "Sanket"
}
```

---

### Get all travel plans

```http
GET /all
```

---

### Get travel plan by ID

```http
GET /find/{planId}
```

Example:

```http
GET /find/2
```

---

### Update travel plan

```http
PUT /update
```

---

### Delete travel plan

```http
DELETE /delete/{planId}
```

Example:

```http
DELETE /delete/2
```

---

### Change status

```http
PUT /status-change/{planId}/{status}
```

Example:

```http
PUT /status-change/2/inactive
```

---

## Database Tables

### JRTP701_PLAN_CATEGORY

Stores:

- categoryId
- categoryName
- activeSW
- createdDate
- updatedDate
- createdBy
- updatedBy

---

### JRTP701_TRAVEL_PLAN

Stores:

- planId
- planName
- planMinBudget
- planDescription
- planCategoryId
- activeSW
- createdDate
- updatedDate
- createdBy
- updatedBy

---

## Configuration

Application messages are configured in:

```text
application.yml
```

Example:

```yaml
plan:
  module:
    messages:
      save-success: Travel plan saved successfully with ID :
      save-failure: Problem saving travel plan
      update-success: updated successfully
      delete-success: deleted successfully
```

---

## Run Project

### Clone

```bash
git clone https://github.com/yourusername/JRTP701-MiniProj01-CURDOperations.git
```

---

### Build

```bash
mvn clean install
```

---

### Run

Using Maven:

```bash
mvn spring-boot:run
```

Or run Spring Boot main class from Eclipse.

---

## Future Improvements

- Swagger/OpenAPI documentation
- Validation using Bean Validation
- Global exception handling
- Authentication and authorization
- Frontend integration
- Pagination and filtering

---

## Author

**Sanket Mishra**

MCA Student  
Java developer

---

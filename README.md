# Employee Management System using Java Spring Boot

## Project Overview

This project implements a simple yet comprehensive Employee Management System using Java with Spring Boot. The system allows managing employees, departments, and project assignments through a RESTful API.

## Features

- CRUD operations for employees, departments, and projects.
- Basic authentication for API security.
- Global exception handling with custom error messages.
- Data validation using Spring's validation annotations.
- Audit logging for entity CRUD operations.
- Performance optimization using Spring Boot's caching mechanisms.

## Requirements

- Java 8 or higher
- Maven 3.6.x or Gradle 6.x
- Postman (for API testing)

## Setup Instructions

### Clone the repository

```bash
git clone <repository_url>
cd employee-management-system

## Build the project

### If using Maven:

```bash
mvn clean install -U 

## Run the application
### If using Maven:
```bash
mvn spring-boot:run

### The application will start at http://localhost:8080.


## API Documentation

### Swagger UI

Navigate to [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) for detailed API documentation.

### API Endpoints

#### Authentication

**Basic Authentication**

Use the following credentials to access the APIs:


- Username: admin, Password: password (for admin access)

#### Employee API Endpoints

- **GET** `/api/employees`: Retrieves all employees.
- **GET** `/api/employees/{id}`: Retrieves an employee by ID.
- **POST** `/api/employees`: Creates a new employee.
- **PUT** `/api/employees/{id}`: Updates an existing employee.
- **DELETE** `/api/employees/{id}`: Deletes an employee by ID.

#### Department API Endpoints

- **GET** `/departments`: Retrieves all departments.
- **GET** `/departments/{id}`: Retrieves a department by ID.
- **POST** `/departments`: Creates a new department.
- **PUT** `/departments/{id}`: Updates an existing department.
- **DELETE** `/departments/{id}`: Deletes a department by ID.

#### Project API Endpoints

- **GET** `/projects`: Retrieves all projects.
- **GET** `/projects/{id}`: Retrieves a project by ID.
- **POST** `/projects`: Creates a new project.
- **PUT** `/projects/{id}`: Updates an existing project.
- **DELETE** `/projects/{id}`: Deletes a project by ID.

## Testing with Postman

1. **Open Postman**.
2. **Set Basic Authentication**:
   - Select the request type (GET, POST, etc.).
   - Click on the Authorization tab.
   - Choose Basic Auth from the Type dropdown.
   - Enter the username and password accordingly (user/admin).
    - user: admin
    - password:password
3. **Send Requests**:
   - Enter the request URL (e.g., http://localhost:8080/api/employees).
   - Choose the request type (GET, POST, PUT, DELETE).
   - Add request body (for POST and PUT requests).
   - Click Send to execute the request.
4. **View Responses**:
   - Postman will display the HTTP response (status code, headers, body).
   - Verify the response data to ensure CRUD operations are working as expected.

## Advanced Features Implemented

- **Security Implementation**: Basic authentication to secure API endpoints.
```bash
curl -u admin:password http://localhost:8080/api/employees
- **Testing**: Unit and integration tests using JUnit and Spring Test.
- **Exception Handling**: Global exception handling with custom error messages.
- **Data Validation**: Validation of request payloads using Spring's validation annotations (applied to Employee operations).
- **Audit Logging (AOP)**: Logging of entity CRUD operations with user actions and timestamps (applied to Employee operations).
- **Performance (Cache)**: Optimized API performance using Spring Boot's caching mechanisms (applied to Employee operations).

> Extend these advanced features to Department and Project entities as per your requirements.

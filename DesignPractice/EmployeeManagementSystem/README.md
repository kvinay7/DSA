# Employee Management System (EMS)

## Problem Statement

Design and implement a full-stack Employee Management System (EMS) that allows users to manage employee information through a web application.

The system should expose REST APIs using Java Spring Boot and provide a React-based user interface for interacting with employee data.

The application must follow a layered architecture using:

* Models (Entities / DTOs)
* Repository Layer
* Service Layer
* Exception Handling Layer
* Controller Layer
* React UI

---

## Functional Requirements

### Employee Fields

Each employee contains:

* Employee ID
* Name
* Email
* Age
* Salary
* Department
* Active Status
* Created Date
* Updated Date

---

### Create Employee

Users should be able to create a new employee.

Validation Rules:

* Name cannot be empty
* Email must be valid
* Email must be unique
* Age must be greater than 0
* Salary must be greater than 0

---

### Get Employee By ID

Users should be able to retrieve employee details using Employee ID.

If employee does not exist:

* Return EmployeeNotFoundException

---

### Get All Employees

Users should be able to view all employees.

Support:

* Pagination
* Sorting
* Filtering by department
* Filtering by active status

Examples:

* Sort by name
* Sort by salary
* Page size = 10
* Page number = 2

---

### Update Employee

Users should be able to update:

* Name
* Email
* Age
* Salary
* Department

Validation rules should still apply.

---

### Delete Employee

Implement Soft Delete.

Requirements:

* Employee record should remain in database
* Active Status should become false
* Deleted employees should not appear in normal employee listing

---

## Technical Requirements

### Backend

Use:

* Java 17+
* Spring Boot
* Spring Data JPA
* H2 for the starter setup
* Lombok
* Validation API

Architecture:

EmployeeController
↓
EmployeeService
↓
EmployeeRepository
↓
MySQL Database

---

### Exception Handling

Create custom exceptions:

* EmployeeNotFoundException
* DuplicateEmailException
* ValidationException

Implement:

* GlobalExceptionHandler
* Standard Error Response

Example Response:

{
"timestamp": "...",
"status": 404,
"message": "Employee not found"
}

---

### API Endpoints

POST /employees

GET /employees/{id}

GET /employees

PUT /employees/{id}

DELETE /employees/{id}

Current starter setup:

* `EmployeeController` matches these endpoints
* `EmployeeService` supports create, get by id, get all, update, and delete
* `H2` is used now so the backend can run without an external database
* Bean validation is enabled on the `Employee` model
* Custom exceptions and a global handler are added for API errors

---

### Frontend

Use React.

Pages:

1. Employee List
2. Create Employee
3. Update Employee
4. Employee Details

Features:

* Search
* Pagination
* Sorting
* Form Validation
* Error Messages

---

## Non-Functional Requirements

* Clean code
* Layered architecture
* Proper validation
* Exception handling
* RESTful API design
* Reusable React components
* Production-ready structure

---

## Development Checklist

1. Install the required software
2. Create the Spring Boot starter project
3. Add the required `pom.xml` dependencies
4. Verify the main application class
5. Run the application locally
6. Define the JPA entities
7. Build repository, exception, service, and controller layers

---

## Setup Notes

* Java 17 or later
* Maven for build and run commands
* Spring Boot as the backend framework
* Spring Web, Validation, and Data JPA starters
* H2 for the in-memory database during development
* Lombok support enabled in the IDE
* Postman for testing REST APIs
* Backend REST APIs first, UI later

---

## Application Run Steps

* Open a terminal in `DSA/DesignPractice/EmployeeManagementSystem`
* Run `mvn spring-boot:run`
* Visit `http://localhost:8080`
* Open the H2 console at `http://localhost:8080/h2-console`
* Use `jdbc:h2:mem:emsdb` as the JDBC URL
* Test the REST endpoints with Postman after the controller is added


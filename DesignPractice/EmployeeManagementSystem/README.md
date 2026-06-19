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
* MySQL
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

## Setup Notes

* Java 17+
* Maven
* Spring Boot project
* Spring Web, Validation, Data JPA
* H2 for in-memory database
* Lombok support in IDE
* Postman for API testing
* Start with backend REST APIs first

---

## Application Run Steps

* Open terminal in `DSA/DesignPractice/EmployeeManagementSystem`
* Run `mvn spring-boot:run` or `mvn -f DSA\DesignPractice\EmployeeManagementSystem\pom.xml spring-boot:run`
* Open `http://localhost:8080`
* Open H2 console at `http://localhost:8080/h2-console`
* Use `jdbc:h2:mem:emsdb` as the JDBC URL
* Test APIs with Postman after adding controllers


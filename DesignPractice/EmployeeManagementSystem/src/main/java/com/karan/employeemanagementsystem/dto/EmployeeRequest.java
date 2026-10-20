package com.karan.employeemanagementsystem.dto;

import java.math.BigDecimal;

import com.karan.employeemanagementsystem.models.Department;
import com.karan.employeemanagementsystem.models.Employee;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeRequest(
        @NotBlank(message = "Name cannot be empty") String name,
        @NotBlank(message = "Email cannot be empty") @Email(message = "Email must be valid") String email,
        @NotNull(message = "Age is required") @Min(value = 1, message = "Age must be greater than 0") Integer age,
        @NotNull(message = "Salary is required") @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0") BigDecimal salary,
        @NotNull(message = "Department is required") Department department
) {
    public Employee toEntity() {
        Employee employee = new Employee();
        employee.setName(name.trim());
        employee.setEmail(email.trim());
        employee.setAge(age);
        employee.setSalary(salary);
        employee.setDepartment(department);
        return employee;
    }
}

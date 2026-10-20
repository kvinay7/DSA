package com.karan.employeemanagementsystem.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.karan.employeemanagementsystem.models.Department;
import com.karan.employeemanagementsystem.models.Employee;

public record EmployeeResponse(
        Long id,
        String name,
        String email,
        Integer age,
        BigDecimal salary,
        Department department,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static EmployeeResponse fromEntity(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getAge(),
                employee.getSalary(),
                employee.getDepartment(),
                employee.isActive(),
                employee.getCreatedAt(),
                employee.getUpdatedAt()
        );
    }
}

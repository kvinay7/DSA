package com.karan.employeemanagementsystem.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.karan.employeemanagementsystem.dto.EmployeeRequest;
import com.karan.employeemanagementsystem.dto.EmployeeResponse;
import com.karan.employeemanagementsystem.exception.DuplicateEmailException;
import com.karan.employeemanagementsystem.exception.EmployeeNotFoundException;
import com.karan.employeemanagementsystem.exception.ValidationException;
import com.karan.employeemanagementsystem.models.Department;
import com.karan.employeemanagementsystem.models.Employee;
import com.karan.employeemanagementsystem.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeResponse createEmployee(EmployeeRequest request) {
        String normalizedEmail = normalizeEmail(request.email());
        if (employeeRepository.findByEmail(normalizedEmail).isPresent()) {
            throw new DuplicateEmailException("Email already exists");
        }

        Employee employee = request.toEntity();
        employee.setEmail(normalizedEmail);
        return EmployeeResponse.fromEntity(employeeRepository.save(employee));
    }

    public List<EmployeeResponse> getAllEmployees(int page, int size, String sortBy, String sortDir,
            Department department, Boolean active) {
        if (page < 0) {
            throw new ValidationException("Page number cannot be negative");
        }
        if (size <= 0) {
            throw new ValidationException("Page size must be greater than 0");
        }

        Sort.Direction direction = sortDir.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        String sortField = getValidSortField(sortBy);

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortField));
        Page<Employee> employeesPage;

        if (department != null && active != null) {
            employeesPage = employeeRepository.findByDepartmentAndActiveTrue(department, pageable);
        } else if (department != null) {
            employeesPage = employeeRepository.findByDepartmentAndActiveTrue(department, pageable);
        } else if (active != null) {
            if (active) {
                employeesPage = employeeRepository.findByActiveTrue(pageable);
            } else {
                employeesPage = employeeRepository.findByActiveFalse(pageable);
            }
        } else {
            employeesPage = employeeRepository.findByActiveTrue(pageable);
        }

        return employeesPage.getContent().stream()
                .map(EmployeeResponse::fromEntity)
                .toList();
    }

    public EmployeeResponse getEmployeeById(Long id) {
        return EmployeeResponse.fromEntity(employeeRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found")));
    }

    public EmployeeResponse updateEmployee(Long id, EmployeeRequest request) {
        Employee existingEmployee = employeeRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        String normalizedEmail = normalizeEmail(request.email());
        if (employeeRepository.existsByEmailAndIdNot(normalizedEmail, id)) {
            throw new DuplicateEmailException("Email already exists");
        }

        existingEmployee.setName(request.name().trim());
        existingEmployee.setEmail(normalizedEmail);
        existingEmployee.setAge(request.age());
        existingEmployee.setSalary(request.salary());
        existingEmployee.setDepartment(request.department());

        return EmployeeResponse.fromEntity(employeeRepository.save(existingEmployee));
    }

    public void deleteEmployee(Long id) {
        Employee existingEmployee = employeeRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        existingEmployee.setActive(false);
        employeeRepository.save(existingEmployee);
    }

    private String normalizeEmail(String email) {
        if (email == null) {
            return null;
        }
        return email.trim().toLowerCase();
    }

    private String getValidSortField(String sortBy) {
        return switch (sortBy == null ? "id" : sortBy.toLowerCase()) {
            case "name" -> "name";
            case "salary" -> "salary";
            case "age" -> "age";
            case "department" -> "department";
            case "email" -> "email";
            default -> "id";
        };
    }
}

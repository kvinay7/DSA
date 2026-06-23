package com.karan.employeemanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.karan.employeemanagementsystem.exception.DuplicateEmailException;
import com.karan.employeemanagementsystem.exception.EmployeeNotFoundException;
import com.karan.employeemanagementsystem.models.Employee;
import com.karan.employeemanagementsystem.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
            throw new DuplicateEmailException("Email already exists");
        }
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findByActiveTrue();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        if (employeeRepository.existsByEmailAndIdNot(updatedEmployee.getEmail(), id)) {
            throw new DuplicateEmailException("Email already exists");
        }

        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setAge(updatedEmployee.getAge());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        existingEmployee.setDepartment(updatedEmployee.getDepartment());

        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        Employee existingEmployee = employeeRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

        existingEmployee.setActive(false);
        employeeRepository.save(existingEmployee);
    }
}

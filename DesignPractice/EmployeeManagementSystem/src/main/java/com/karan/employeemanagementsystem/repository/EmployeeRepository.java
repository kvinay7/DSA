package com.karan.employeemanagementsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karan.employeemanagementsystem.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

    List<Employee> findByActiveTrue();

    List<Employee> findByDepartmentAndActiveTrue(com.karan.employeemanagementsystem.models.Department department);

    Optional<Employee> findByIdAndActiveTrue(Long id);

    boolean existsByEmailAndIdNot(String email, Long id);
}

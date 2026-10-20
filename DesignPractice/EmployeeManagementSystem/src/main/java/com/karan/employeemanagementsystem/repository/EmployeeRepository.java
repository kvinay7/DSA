package com.karan.employeemanagementsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.karan.employeemanagementsystem.models.Department;
import com.karan.employeemanagementsystem.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

    Page<Employee> findByActiveTrue(Pageable pageable);

    Page<Employee> findByActiveFalse(Pageable pageable);

    Page<Employee> findByDepartmentAndActiveTrue(Department department, Pageable pageable);

    List<Employee> findByDepartmentAndActiveTrue(Department department);

    Optional<Employee> findByIdAndActiveTrue(Long id);

    boolean existsByEmailAndIdNot(String email, Long id);
}

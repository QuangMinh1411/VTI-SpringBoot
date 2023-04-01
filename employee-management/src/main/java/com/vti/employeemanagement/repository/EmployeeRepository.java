package com.vti.employeemanagement.repository;

import com.vti.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<Employee> findEmployeeByName(String name);
    Optional<Employee> findEmployeeByNameContainingIgnoreCase(String search);

    List<Employee> findEmployeeByAgeBetween(String age1, String age2);
}

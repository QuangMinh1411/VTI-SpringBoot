package com.vti.employeemanagement.service;

import com.vti.employeemanagement.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> listAll();
    Employee getEmployeeById(Integer id);
    Employee updateEmployee(Integer id,Employee employee);

    Employee findEmployeeByName(String name);

    void deleteEmployee(Integer id);

    List<Employee> findEmployeeByAgeBetween(String a, String b);
}

package com.vti.employeemanagement.service;

import com.vti.employeemanagement.entity.Employee;
import com.vti.employeemanagement.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repo;
    @Override
    public Employee saveEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public List<Employee> listAll() {

        return repo.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {

        return repo.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        Employee exist = getEmployeeById(id);
        exist.setName(employee.getName());
        exist.setAge(employee.getAge());
        exist.setTitle(employee.getTitle());
        return repo.save(exist);
    }

    @Override
    public Employee findEmployeeByName(String name) {
        return repo.findEmployeeByName(name).orElse(null);
    }

    @Override
    public void deleteEmployee(Integer id) {
        Employee exist = getEmployeeById(id);
        repo.delete(exist);
    }

    @Override
    public List<Employee> findEmployeeByAgeBetween(String a, String b) {
        return repo.findEmployeeByAgeBetween(a,b);
    }


}

package com.vti.employeemanagement.repository;

import com.vti.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query("SELECT e FROM Employee e WHERE e.name=:name")
    Optional<Employee> findEmployeeByName(@Param("name") String name);
    List<Employee> findEmployeeByNameContainingIgnoreCase(String search);

    @Query("SELECT e FROM Employee e WHERE e.age>?1 AND e.age<?2")
    List<Employee> findEmployeeByAgeBetween(String age1, String age2);
    @Query("SELECT e FROM Employee e ORDER BY e.age ASC ")
    List<Employee> sortEmployeeByAge();
    @Query(value = "SELECT * FROM Employee WHERE title =?1",nativeQuery = true)
    List<Employee> findByTitle(String title);



}

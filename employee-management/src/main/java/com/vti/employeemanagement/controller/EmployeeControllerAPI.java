package com.vti.employeemanagement.controller;

import com.vti.employeemanagement.entity.Employee;
import com.vti.employeemanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeControllerAPI {
    private final EmployeeService service;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        return new ResponseEntity<>(service.getEmployeeById(id),HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<?> getEmployeeByName(@RequestParam("name")String name){
        Employee employee = service.findEmployeeByName(name);
        if(employee!=null)
            return new ResponseEntity<>(service.findEmployeeByName(name),HttpStatus.OK);
        else
            return new ResponseEntity<>("Can not find",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/age")
    public ResponseEntity<?> getEmployeeAgeBetween(@RequestParam("min") String min
            ,@RequestParam("max")String max){
        return new ResponseEntity<>(service.findEmployeeByAgeBetween(min,max),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(service.saveEmployee(employee),HttpStatus.CREATED);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        return new ResponseEntity<>(service.updateEmployee(id,employee),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer id){
        service.deleteEmployee(id);
        return ResponseEntity.ok().body("Delete successfully");
    }
}

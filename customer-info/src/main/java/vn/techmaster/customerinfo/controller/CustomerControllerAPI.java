package vn.techmaster.customerinfo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.customerinfo.model.CustomerPoJo;
import vn.techmaster.customerinfo.repository.CustomerRepository;

@RestController
@RequestMapping("/api")
public class CustomerControllerAPI {
    private final CustomerRepository repo;

    public CustomerControllerAPI(CustomerRepository repo) {
        this.repo = repo;
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(repo.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(repo.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody CustomerPoJo pojo){
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(pojo));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable("id") Integer id,@RequestBody CustomerPoJo pojo){
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.update(id,pojo));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(repo.delete(id));
    }
}

package vn.vti.jsondemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.vti.jsondemo.model.Person;
import vn.vti.jsondemo.repositories.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonController {
    private final PersonRepository repo;

    public PersonController(PersonRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public ResponseEntity<List<Person>> listAll(){
        return new ResponseEntity<>(repo.getPeople(), HttpStatus.OK);
    }
}

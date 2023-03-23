package vn.vti.jsondemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/filter/")
    public ResponseEntity<?> filterByGenderAndSalarySorting(@RequestParam("gender")String gender,@RequestParam("sorting")String sorting){
        return new ResponseEntity<>(repo.getByGenderAndSortBySalary(gender,sorting),HttpStatus.OK);
    }

    @GetMapping("/jobCount")
    public ResponseEntity<?> coutingJob(){
        return new ResponseEntity<>(repo.countPeopleByJob(),HttpStatus.OK);
    }

    @GetMapping("/citySalary")
    public ResponseEntity<?> topCitySalary(){
        return new ResponseEntity<>(repo.count5TopSalaryFromCity(),HttpStatus.OK);
    }

}

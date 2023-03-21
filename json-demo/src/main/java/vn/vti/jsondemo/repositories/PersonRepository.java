package vn.vti.jsondemo.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import vn.vti.jsondemo.model.Person;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonRepository {
    private List<Person> people = new ArrayList<>();

    public PersonRepository() {
        try {
            File file = ResourceUtils.getFile("classpath:static/personsmall.json");
            ObjectMapper mapper = new ObjectMapper();
            people.addAll(mapper.readValue(file, new TypeReference<List<Person>>(){}));
            people.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Person> getPeople(){
        return people;
    }
}

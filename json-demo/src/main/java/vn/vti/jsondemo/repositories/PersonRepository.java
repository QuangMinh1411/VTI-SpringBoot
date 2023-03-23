package vn.vti.jsondemo.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import vn.vti.jsondemo.model.Person;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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

    public List<Person> getByGenderAndSortBySalary(String gender,String sorting){
        if(sorting.equals("asc")){
          return  people.stream().filter(person -> person.getGender().equals(gender)).sorted(Comparator.comparing(Person::getSalary)).collect(Collectors.toList());
        }else{
          return people.stream().filter(person -> person.getGender().equals(gender)).sorted(Comparator.comparing(Person::getSalary).reversed()).collect(Collectors.toList());
        }
    }

    public Map<String,Long> countPeopleByJob(){

        return people
                .stream()
                .collect(Collectors.groupingBy(Person::getJob, Collectors.counting()));
    }

    public Map<String,Integer> countPeopleByJob2(){
        Map<String,Integer> results = new HashMap<>();
        for (Person person : people) {
            if(results.get(person.getJob())==null){
                results.put(person.getJob(),1);
            }else{
                results.put(person.getJob(), results.get(person.getJob())+1);
            }
        }
        return results;
    }

    private List<Person> top5Person(String city){
        var cityPeoplesortBySalary = people.stream().filter(person -> person.getCity().equals(city))
                .sorted(Comparator.comparing(Person::getSalary).reversed())
                .limit(5)
                .collect(Collectors.toList());
        return cityPeoplesortBySalary;
    }

    public Map<String,List<Person>> count5TopSalaryFromCity(){
        Map<String,List<Person>> results = new HashMap<>();

        for(Person person:people){
            results.put(person.getCity(),this.top5Person(person.getCity()));
        }
        return results;
    }


}

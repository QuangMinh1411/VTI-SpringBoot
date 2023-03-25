package vn.vti.jsondemo.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import vn.vti.jsondemo.model.Car;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarRepository {
    private List<Car> cars = new ArrayList<>();

    public CarRepository() {
        try {
            File file = ResourceUtils.getFile("classpath:static/car.json");
            ObjectMapper mapper = new ObjectMapper();
            cars.addAll(mapper.readValue(file, new TypeReference<List<Car>>(){}));
            cars.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Car> list(){
        return cars;
    }

    public Car saveCar(Car car){
        int id;
        if (cars.isEmpty()) {
            id = 1;
        } else {
            Car lastCar = cars.get(cars.size() - 1);
            id = lastCar.getId() + 1;
        }
        car.setId(id);
        cars.add(car);
        return car;
    }

    public Car findByYear(int year){
       return cars.stream().filter(car -> car.getYear()==year).findFirst().orElse(null);
    }

    public List<Car> findByMaker(String maker){
        return cars.stream().filter(car -> car.getMaker().equals(maker)).collect(Collectors.toList());
    }

    public Car findById(Integer id){
        return cars.stream().filter(car -> car.getId()==id).findFirst().orElse(null);

    }

    public List<Car> sortBy(String sorting){
        if(sorting.equals("asc"))
            Collections.sort(cars, Comparator.comparing(Car::getYear));
        else
            Collections.sort(cars,Comparator.comparing(Car::getYear).reversed());
        return cars;
    }

    public void deleteCar(Integer id){
       cars = cars.stream().filter(car -> car.getId()!=id).collect(Collectors.toList());
    }

    public Car updateCar(Integer id,Car newcar){

        Car car = cars.stream().filter(car1 -> car1.getId()==id).findFirst().orElse(null);
        if(car!=null){
            car.setModel(newcar.getModel());
            car.setMaker(newcar.getMaker());
            car.setYear(newcar.getYear());
            cars.set(cars.indexOf(car),car);
        }

        return car;
    }
}

package vn.vti.jsondemo.service;

import vn.vti.jsondemo.model.Car;

import java.util.List;

public interface CarService {
    List<Car> listCar();
    Car saveCar(Car car);
    Car findByYear(Integer year);

    Car findByMaker(String maker);
    Car findById(Integer id);
    Car sortBy(String sorting);
    void deleteCar(Integer id);
    Car updateCar(Car car,Integer id);
}

package com.vti.training.jpademo.service;

import com.vti.training.jpademo.entity.Car;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface CarService {
    List<Car> list();
    Car findById(Long id);

    void deleteById(Long id);
    Car updateCar(Long id, Car car);
}

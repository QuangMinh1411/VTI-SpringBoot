package com.vti.training.jpademo.service;

import com.vti.training.jpademo.entity.Car;
import com.vti.training.jpademo.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepo;
    @Override
    public List<Car> list() {
        return carRepo.findAll();
    }

    @Override
    public Car findById(Long id) {

        return carRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        carRepo.deleteById(id);
    }

    @Override
    public Car updateCar(Long id, Car car) {
        Car exist = carRepo.findById(id).get();
        exist.setModel(car.getModel());
        exist.setMaker(car.getMaker());
        exist.setYear(car.getYear());
        carRepo.save(exist);
        return exist;
    }
}

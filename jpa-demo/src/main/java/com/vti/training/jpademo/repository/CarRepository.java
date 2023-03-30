package com.vti.training.jpademo.repository;

import com.vti.training.jpademo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}

package com.vti.training.jpademo.controller;

import com.vti.training.jpademo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cars")
public class CarControllerAPI {
    private final CarService carService;

    @GetMapping
    public ResponseEntity<?> getALl(){
        return new ResponseEntity<>(carService.list(), HttpStatus.OK);
    }
}

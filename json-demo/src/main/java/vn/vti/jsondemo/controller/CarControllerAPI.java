package vn.vti.jsondemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vti.jsondemo.model.Car;
import vn.vti.jsondemo.repositories.CarRepositoryMVC;
import vn.vti.jsondemo.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarControllerAPI {
//    private final CarRepositoryMVC carRepo;
    private final CarService carService;


    @GetMapping
    public ResponseEntity<List<Car>> getAll(){
        return ResponseEntity.ok(carService.listCar());
    }

    @PostMapping
    public ResponseEntity<?> saveCar(@RequestBody Car car){
        carService.saveCar(car);
        return ResponseEntity.ok(car);
    }

//    @GetMapping("/{year}")
//    public ResponseEntity<?> getByYear(@PathVariable("year") Integer year){
//
//        return ResponseEntity.ok(carRepo.findByYear(year));
//    }

//    @GetMapping("/maker")
//    public ResponseEntity<?> getByMaker(@RequestParam("value") String value){
//        return new ResponseEntity<>(carRepo.findByMaker(value),HttpStatus.OK);
//    }

//    @GetMapping("/sorting")
//    public ResponseEntity<?> sortByYear(@RequestParam("sorted") String sorted){
//        return new ResponseEntity<>(carRepo.sortBy(sorted),HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        carService.deleteCar(id);
        return ResponseEntity.ok("Delete success");
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>updateCar(@PathVariable Integer id, @RequestBody Car car){
        return ResponseEntity.ok(carService.updateCar(car,id));
    }

}

package vn.vti.jsondemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vti.jsondemo.model.Car;
import vn.vti.jsondemo.repositories.CarRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarControllerAPI {
    private final CarRepository carRepo;

    public CarControllerAPI(CarRepository carRepo) {
        this.carRepo = carRepo;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAll(){
        return ResponseEntity.ok(carRepo.list());
    }

    @PostMapping
    public ResponseEntity<?> saveCar(@RequestBody Car car){
        carRepo.saveCar(car);
        return ResponseEntity.ok(car);
    }

    @GetMapping("/{year}")
    public ResponseEntity<?> getByYear(@PathVariable("year") Integer year){

        return ResponseEntity.ok(carRepo.findByYear(year));
    }

    @GetMapping("/maker")
    public ResponseEntity<?> getByMaker(@RequestParam("value") String value){
        return new ResponseEntity<>(carRepo.findByMaker(value),HttpStatus.OK);
    }

    @GetMapping("/sorting")
    public ResponseEntity<?> sortByYear(@RequestParam("sorted") String sorted){
        return new ResponseEntity<>(carRepo.sortBy(sorted),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        carRepo.deleteCar(id);
        return ResponseEntity.ok("Delete success");
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>updateCar(@PathVariable Integer id, @RequestBody Car car){
        return ResponseEntity.ok(carRepo.updateCar(id,car));
    }

}

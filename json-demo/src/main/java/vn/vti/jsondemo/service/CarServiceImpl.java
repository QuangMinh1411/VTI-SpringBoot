package vn.vti.jsondemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.vti.jsondemo.model.Car;
import vn.vti.jsondemo.repositories.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepo;

    @Override
    public List<Car> listCar() {
        return carRepo.findAll();
    }

    @Override
    public Car saveCar(Car car) {
        return carRepo.save(car);
    }

    @Override
    public Car findByYear(Integer year) {

        return null;
    }

    @Override
    public Car findByMaker(String maker) {
        return null;
    }

    @Override
    public Car findById(Integer id) {
        Optional<Car> opcar = carRepo.findById(id);
        if(opcar.isPresent()){
            return opcar.get();
        }else return null;
    }

    @Override
    public Car sortBy(String sorting) {
        return null;
    }

    @Override
    public void deleteCar(Integer id) {
        if(carRepo.existsById(id)){
            carRepo.deleteById(id);
        }
    }

    @Override
    public Car updateCar(Car car,Integer id) {
        Car exist = carRepo.findById(id).get();
        exist.setModel(car.getModel());
        exist.setMaker(car.getMaker());
        exist.setYearmade(car.getYearmade());
        carRepo.save(exist);
        return exist;
    }
}

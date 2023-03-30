package vn.vti.jsondemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.vti.jsondemo.model.Car;
@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
}

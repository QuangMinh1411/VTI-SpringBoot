package vn.vti.jsondemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.vti.jsondemo.repositories.CarRepository;

@Controller
@RequestMapping("/")
public class CarController {
    private final CarRepository repo;

    public CarController(CarRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String home(){
        return "home";
    }
    @GetMapping("/cars")
    public String carList(Model model){
        model.addAttribute("cars",repo.list());
        return "cars";
    }


}

package vn.vti.jsondemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.vti.jsondemo.model.Car;
import vn.vti.jsondemo.repositories.CarRepository;

import java.util.List;

@Controller
@RequestMapping("/")
public class CarController {
    private final CarRepository repo;

    public CarController(CarRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String home(){
        return "index";
    }
    @GetMapping("/listAll")
    public String getAll(Model model,@RequestParam(value = "direction",required = false)String direction){
        if(direction==null){
            model.addAttribute("cars",repo.list());
        }else{
            List<Car> cars = repo.sortBy(direction);
            model.addAttribute("cars",cars);
        }
        return "list";
    }


    @GetMapping("/search")
    public String search(HttpServletRequest request, Model model){
        String maker = request.getParameter("maker");
        if(maker==""){
            model.addAttribute("cars",repo.list());
            return "redirect:/listAll";
        }else{
            model.addAttribute("cars",repo.findByMaker(maker));
            return "list";
        }
    }

    @GetMapping("/create")
    public String createCustomer(Model model){
        model.addAttribute("car",new Car());
        return "CarForm";
    }

    @PostMapping("/post")
    public String postInfo(@ModelAttribute("car") Car car, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            if(car.getId()!=null){
                repo.updateCar(car.getId(), car);
            }else{
                repo.saveCar(car);
            }
            model.addAttribute("cars", repo.list());
            return "redirect:/listAll";
        }
        return "CarForm";
    }

    @GetMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") Integer id, Model model) {
        Car car = repo.findById(id);
        model.addAttribute("car",car);
        return "CarForm";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Integer id, Model model){
        repo.deleteCar(id);
        model.addAttribute("customers",repo.list());
        return "redirect:/listAll";
    }

}

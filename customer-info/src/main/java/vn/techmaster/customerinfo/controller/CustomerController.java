package vn.techmaster.customerinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.customerinfo.mapper.CustomerMapper;
import vn.techmaster.customerinfo.model.Customer;
import vn.techmaster.customerinfo.repository.CustomerRepository;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository repo;

    @GetMapping
    public String home(){
        return "index";
    }

    @GetMapping("/listAll")
    public String getAll(Model model,@RequestParam(value = "direction",required = false)String direction){
        if(direction==null){
            model.addAttribute("customers",repo.getAll());
        }else{
            List<Customer> customers = repo.sort(direction);
            model.addAttribute("customers",customers);
        }
        return "list";
    }




    @GetMapping("/search")
    public String search(HttpServletRequest request,Model model){
        String email = request.getParameter("email");
        if(email==""){
            model.addAttribute("customers",repo.getAll());
            return "redirect:/listAll";
        }else{
            model.addAttribute("customers",repo.findEmail(email));
            return "list";
        }
    }

    @GetMapping("/create")
    public String createCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "CustomerForm";
    }

    @PostMapping("/post")
    public String postInfo(@ModelAttribute("customer") Customer customer, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            if(customer.getId()>0){
                repo.update(customer.getId(), CustomerMapper.INSTANCE.customerToPojo(customer));
            }else{
                repo.save(CustomerMapper.INSTANCE.customerToPojo(customer));

            }
            model.addAttribute("customers", repo.getAll());
            return "redirect:/listAll";
        }
        return "CustomerForm";
    }

    @GetMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model) {
        Customer customer = repo.findById(id);
        model.addAttribute("customer",customer);
        return "CustomerForm";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") int id, Model model){
        repo.delete(id);
        model.addAttribute("customers",repo.getAll());
        return "redirect:/listAll";
    }

}

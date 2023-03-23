package vn.techmaster.customerinfo.repository;

import org.springframework.stereotype.Repository;
import vn.techmaster.customerinfo.mapper.CustomerMapper;
import vn.techmaster.customerinfo.model.Customer;
import vn.techmaster.customerinfo.model.CustomerPoJo;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    public CustomerRepository() {
        customers.add(new Customer(1,"John","john@yahoo.com",12395L));
        customers.add(new Customer(2,"Mary","mary@yahoo.com",22327L));
        customers.add(new Customer(3,"Bill","bill@yahoo.com",22357L));
    }
    public List<Customer> getAll(){
        return customers;
    }
    public Customer findById(Integer id){
        return customers.stream().filter(c->c.getId()==id).findFirst().orElse(null);
    }

    public Customer findByEmail(String email){
        return customers.stream().filter(c->c.getEmail()==email).findFirst().orElse(null);
    }

    public Customer update(Integer id, CustomerPoJo pojo){
        Customer update_customer = CustomerMapper.INSTANCE.pojoToCustomer(pojo);
        update_customer.setId(id);
        customers= customers.stream().map(c->{
            if(c.getId()==id) return update_customer;
            else return c;
        }).collect(Collectors.toList());
        return update_customer;
    }
    public Customer save(CustomerPoJo pojo){
        Customer customer = CustomerMapper.INSTANCE.pojoToCustomer(pojo);
        Customer lastCustomer = customers.get(customers.size() - 1);
        var id = lastCustomer.getId() + 1;
        customer.setId(id);
        customers.add(customer);
        return customer;
    }
    public Customer create(Customer customer){
        int id;
        if (customers.isEmpty()) {
            id = 1;
        } else {
            Customer lastCustomer = customers.get(customers.size() - 1);
            id = lastCustomer.getId() + 1;
        }
        customer.setId(id);
        customers.add(customer);
        return customer;
    }
    public Customer delete(Integer id){
        Optional<Customer> customer = customers.stream().filter(c->c.getId()==id).findFirst();
        if(customer.isPresent()){
            customers.remove(customer.get());
            return customer.get();
        }
        return null;
    }

    public Customer findEmail(String email){
        return customers.stream().filter(c->c.getEmail().contains(email)).findAny().orElse(null);
    }

    public List<Customer> sort(String direction){
//        orderList.forEach(l-> System.out.println(l.getFullname()));
        switch (direction){
            case "asc":
                return getAll().stream().sorted(Comparator.comparing(Customer::getFullname)).collect(Collectors.toList());
            case "desc":
                return getAll().stream().sorted(Comparator.comparing(Customer::getFullname).reversed()).collect(Collectors.toList());
            default:
                return getAll();
        }
    }
}

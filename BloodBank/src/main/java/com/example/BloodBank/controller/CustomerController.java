package com.example.BloodBank.controller;

import com.example.BloodBank.model.Customer;
import com.example.BloodBank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/customer")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping()
    public List<Customer> getAllCustomers(){
        return customerService.getAll();
    }
    @PostMapping(
            value = "/register", consumes = "application/json",
            produces = "application/json"
    )
    public Customer registerCustomer(@RequestBody Customer newCustomer){
        return customerService.registerCustomer(newCustomer);
    }
}

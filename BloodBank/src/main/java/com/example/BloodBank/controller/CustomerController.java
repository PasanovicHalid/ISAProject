package com.example.BloodBank.controller;

import com.example.BloodBank.model.Customer;
import com.example.BloodBank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Object> registerCustomer(@Valid @RequestBody Customer newCustomer){
        try {
            customerService.registerCustomer(newCustomer);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.example.BloodBank.service;

import com.example.BloodBank.model.Customer;
import com.example.BloodBank.repository.CustomerRepository;
import com.example.BloodBank.service.service_interface.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    public Customer registerCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}

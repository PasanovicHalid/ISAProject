package com.example.BloodBank.service.service_interface;

import com.example.BloodBank.model.Customer;

import java.util.List;

public interface ICustomerService {
    void registerCustomer(Customer customer);
    List<Customer> getAll();
}

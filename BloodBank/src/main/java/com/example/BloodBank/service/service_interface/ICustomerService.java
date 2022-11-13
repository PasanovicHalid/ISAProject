package com.example.BloodBank.service.service_interface;

import com.example.BloodBank.model.Customer;

import java.util.List;

public interface ICustomerService extends ICRUDService<Customer> {
    Customer registerCustomer(Customer customer);
    List<Customer> getAll();
    Customer FindByUsername(String username) throws Exception;
}

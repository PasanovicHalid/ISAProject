package com.example.BloodBank.service.service_interface;

import com.example.BloodBank.model.Customer;
import com.example.BloodBank.model.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService extends ICRUDService<Customer> {
    void registerCustomer(Customer customer) throws Exception;
    List<Customer> getAll() throws Exception;
    List<Customer> findAllByFirstNameOrLastName(String searchTerm, Pageable page);
    Customer FindByUsername(String username) throws Exception;
    int getCustomersAmountWithSearch(String search);

}

package com.example.BloodBank.service;

import com.example.BloodBank.excpetions.EmailTakenException;
import com.example.BloodBank.excpetions.UsernameTakenException;
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
    public void registerCustomer(Customer customer) throws Exception {

        try {
            for (Customer customerIt : customerRepository.findAll()){
                if (customerIt.getUsername().equals(customer.getUsername())){
                    System.out.println("Username: " + customer.getUsername() +
                            " is taken!");
                    throw new UsernameTakenException(customer.getUsername());
                }
                if (customerIt.getEmail().equals(customer.getEmail())){
                    System.out.println("Email: " + customer.getEmail() +
                            " is taken!");
                    throw new EmailTakenException(customer.getEmail());
                }
            }
            customerRepository.save(customer);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public List<Customer> getAll() throws Exception {
        try {
            return customerRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

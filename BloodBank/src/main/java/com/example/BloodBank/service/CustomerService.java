package com.example.BloodBank.service;

import com.example.BloodBank.excpetions.EntityDoesntExistException;
import com.example.BloodBank.model.Admin;
import com.example.BloodBank.model.Customer;
import com.example.BloodBank.repository.CustomerRepository;
import com.example.BloodBank.service.service_interface.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Customer FindByUsername(String username) {
        return customerRepository.findByUsername(username).get();
    }

    @Override
    public Customer Create(Customer entity) throws Exception {
        return customerRepository.save(entity);
    }

    @Override
    public Customer Read(Long id) throws Exception {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            return customer.get();
        } else {
            throw new EntityDoesntExistException(id);
        }
    }

    @Override
    public Customer Update(Customer entity) throws Exception {
        return customerRepository.save(entity);
    }

    @Override
    public void Delete(Customer entity) throws Exception {
        customerRepository.delete(entity);
    }

    @Override
    public Iterable<Customer> GetAll() throws Exception {
        return customerRepository.findAll();
    }
}

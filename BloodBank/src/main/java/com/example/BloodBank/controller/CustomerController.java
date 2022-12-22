package com.example.BloodBank.controller;

import adapters.CustomerMapper;
import com.example.BloodBank.dto.userDTOs.CustomerDTO;
import com.example.BloodBank.dto.userDTOs.CustomerUpdateDTO;
import com.example.BloodBank.exceptions.EntityDoesntExistException;
import com.example.BloodBank.model.Address;
import com.example.BloodBank.model.Customer;
import com.example.BloodBank.model.User;
import com.example.BloodBank.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
    private final CustomerService customerService;
    private final ModelMapper modelMapper;
    private CustomerMapper customerMapper;
    @Autowired
    public CustomerController(CustomerService customerService, ModelMapper modelMapper){
        this.customerService = customerService;
        this.modelMapper = modelMapper;
        this.customerMapper = new CustomerMapper(modelMapper);
    }
    @GetMapping()
    public ResponseEntity<List<Customer>> getAllCustomers(){
        try {
            return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/search")
    public ResponseEntity<Object> getCustomers(@RequestParam("page") Optional<String> pageNumber,
                                               @RequestParam("size") Optional<String> size,
                                               @RequestParam("search") Optional<String> searchTerm){
        try{
            Pageable page;
            page = PageRequest.of(Integer.valueOf(pageNumber.get()), Integer.valueOf(size.get()));
            List<Customer> customers = customerService.findAllByFirstNameOrLastName(searchTerm.get(),page);

            if(customers.size() == 0){
                return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else{
                return new ResponseEntity<>(customers, HttpStatus.OK);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(
            value = "/register", consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<Object> registerCustomer(@Valid @RequestBody Customer newCustomer){
        try {
            customerService.registerCustomer(newCustomer);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> Update(@Valid @RequestBody CustomerUpdateDTO customerDTO){
        try {
            Customer customer = customerService.Read(customerDTO.getId());
            customer = customerMapper.combineWithCustomerUpdateDTO(customer, customerDTO);
            customer.setAddress(modelMapper.map(customerDTO.getAddress(), Address.class));
            customerService.Update(customer);
            return ResponseEntity.status(HttpStatus.OK).body(customerService.Read(customer.getId()));
        } catch (Exception e){
            if(e instanceof EntityDoesntExistException){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> FindByID(@PathVariable("id") Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(customerService.Read(id));
        } catch (Exception e){
            if(e instanceof EntityDoesntExistException){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping(path="amount")
    public ResponseEntity<Integer> getNumberOfCustomers( @RequestParam("search") Optional<String> searchTerm) {
        try{
            int amount = customerService.getCustomersAmountWithSearch(searchTerm.get());
            return new ResponseEntity<>(amount, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private Customer updateCustomer(Customer customer ,CustomerDTO customerDTO){
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setUsername(customerDTO.getUsername());
        customer.setPassword(customerDTO.getPassword());
        customer.setDob(customerDTO.getDob());
        customer.setEmail(customerDTO.getEmail());
        customer.setGender(customerDTO.getGender());
        customer.setRole(customerDTO.getRole());
        return customer;
    }
}

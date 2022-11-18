package adapters;

import com.example.BloodBank.dto.CustomerDTO;
import com.example.BloodBank.dto.CustomerUpdateDTO;
import com.example.BloodBank.dto.UserDTO;
import com.example.BloodBank.model.Customer;
import com.example.BloodBank.model.User;
import org.modelmapper.ModelMapper;

public class CustomerMapper {
    private static ModelMapper modelMapper;

    public CustomerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public static CustomerDTO toCustomerDTO(Customer customer){
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return customerDTO;
    }

    public static Customer fromCustomerDTO(CustomerDTO customerDTO){
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        return customer;
    }

    public static CustomerUpdateDTO toCustomerUpdateDTO(Customer customer){
        CustomerUpdateDTO customerDTO = modelMapper.map(customer, CustomerUpdateDTO.class);
        return customerDTO;
    }

    public static Customer fromCustomerUpdateDTO(CustomerUpdateDTO customerDTO){
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        return customer;
    }

    public static Customer combineWithCustomerUpdateDTO(Customer customer, CustomerUpdateDTO customerUpdateDTO){
        customer.setFirstName(customerUpdateDTO.getFirstName());
        customer.setLastName(customerUpdateDTO.getLastName());
        customer.setUsername(customerUpdateDTO.getUsername());
        customer.setPassword(customerUpdateDTO.getPassword());
        customer.setEmail(customerUpdateDTO.getEmail());
        customer.setGender(customerUpdateDTO.getGender());
        customer.setDob(customerUpdateDTO.getDob());
        customer.setRole(customerUpdateDTO.getRole());
        return customer;
    }
}

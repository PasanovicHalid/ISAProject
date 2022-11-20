package com.example.BloodBank.service.service_interface;

import com.example.BloodBank.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService extends ICRUDService<User> {
    List<User> findAllByFirstNameOrLastName(String searchTerm, Pageable page);
}

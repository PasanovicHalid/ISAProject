package com.example.BloodBank.service.service_interface;

import com.example.BloodBank.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService extends ICRUDService<User> {
    Page<User> findAllByFirstNameOrLastName(String searchTerm, Pageable page);
}

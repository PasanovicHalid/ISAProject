package com.example.BloodBank.service;

import com.example.BloodBank.adapters.UserMapper;
import com.example.BloodBank.excpetions.EntityDoesntExistException;
import com.example.BloodBank.model.User;
import com.example.BloodBank.repository.UserRepository;
import com.example.BloodBank.service.service_interface.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void Create(User entity) throws Exception {
        userRepository.save(entity);
    }

    @Override
    public User Read(int id) throws Exception {
        Optional<User> admin = userRepository.findById(Long.valueOf(id));
        if(admin.isPresent()){
            return admin.get();
        } else {
            throw new EntityDoesntExistException(id);
        }
    }

    @Override
    public void Update(User entity) throws Exception {
        userRepository.save(entity);
    }

    @Override
    public void Delete(User entity) throws Exception {
        userRepository.delete(entity);
    }

    @Override
    public Iterable<User> GetAll() {
        return userRepository.findAll();
    }
}

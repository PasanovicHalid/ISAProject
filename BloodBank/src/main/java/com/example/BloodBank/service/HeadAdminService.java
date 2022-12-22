package com.example.BloodBank.service;

import com.example.BloodBank.exceptions.EmailTakenException;
import com.example.BloodBank.exceptions.UsernameTakenException;
import com.example.BloodBank.model.Customer;
import com.example.BloodBank.model.HeadAdmin;
import com.example.BloodBank.model.Role;
import com.example.BloodBank.model.User;
import com.example.BloodBank.repository.HeadAdminRepository;
import com.example.BloodBank.repository.UserRepository;
import com.example.BloodBank.service.service_interface.IHeadAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HeadAdminService implements IHeadAdminService {
    private final HeadAdminRepository headAdminRepository;
    private final UserRepository userRepository;
    @Autowired
    public HeadAdminService(HeadAdminRepository headAdminRepository, UserRepository userRepository){
        this.headAdminRepository = headAdminRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void registerHeadAdmin(HeadAdmin headAdmin) throws Exception{
        try {
            if(userRepository.findByUsername(headAdmin.getUsername()).isPresent())
                throw new UsernameTakenException(headAdmin.getUsername());
            if(userRepository.findByEmail(headAdmin.getEmail()).isPresent())
                throw new EmailTakenException(headAdmin.getUsername());

            Create(headAdmin);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public HeadAdmin Create(HeadAdmin entity) throws Exception {
        entity.setRole(Role.HEADADMIN);
        headAdminRepository.save(entity);
        return entity;
    }

    @Override
    public HeadAdmin Read(Long id) throws Exception {
        return null;
    }

    @Override
    public HeadAdmin Update(HeadAdmin entity) throws Exception {
        return null;
    }

    @Override
    public void Delete(HeadAdmin entity) throws Exception {

    }

    @Override
    public Iterable<HeadAdmin> GetAll() throws Exception {
        return null;
    }
}

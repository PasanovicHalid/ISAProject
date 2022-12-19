package com.example.BloodBank.service;

import com.example.BloodBank.exceptions.EntityDoesntExistException;
import com.example.BloodBank.model.NotActivatedUser;
import com.example.BloodBank.repository.NotActivatedUserRepository;
import com.example.BloodBank.service.service_interface.INotActivatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class NotActivatedUserService implements INotActivatedUserService {
    private final NotActivatedUserRepository notActivatedUserRepository;
    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    public NotActivatedUserService(NotActivatedUserRepository notActivatedUserRepository){
        this.notActivatedUserRepository = notActivatedUserRepository;
    }
    @Override
    public NotActivatedUser Create(NotActivatedUser entity) throws Exception {
        String uuid = UUID.randomUUID().toString();
        emailSenderService.sendSimpleEmail(entity.getEmail(), "Blood bank activation", "http://localhost:8086/activate/"+uuid);
        entity.setActivationCode(uuid);
        return notActivatedUserRepository.save(entity);
    }

    @Override
    public NotActivatedUser Read(Long id) throws Exception {
        Optional<NotActivatedUser> user = notActivatedUserRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        } else {
            throw new EntityDoesntExistException();
        }
    }

    @Override
    public NotActivatedUser Update(NotActivatedUser entity) throws Exception {
        return null;
    }

    @Override
    public void Delete(NotActivatedUser entity) throws Exception {
        notActivatedUserRepository.delete(entity);
    }

    @Override
    public Iterable<NotActivatedUser> GetAll() throws Exception {
        return notActivatedUserRepository.findAll();
    }
    public NotActivatedUser ReadByActivationCode(String code) throws Exception {
        Optional<NotActivatedUser> user = notActivatedUserRepository.findByActivationCode(code);
        if(user.isPresent()){
            return user.get();
        } else {
            throw new EntityDoesntExistException();
        }
    }
    public Boolean Activate(String activationCode) throws Exception{
        System.out.println("in activation!");
        return true;
    }
}

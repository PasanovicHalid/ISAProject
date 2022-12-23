package com.example.BloodBank.service;

import com.example.BloodBank.exceptions.EntityDoesntExistException;
import com.example.BloodBank.model.Address;
import com.example.BloodBank.model.NotActivatedUser;
import com.example.BloodBank.model.Role;
import com.example.BloodBank.model.User;
import com.example.BloodBank.repository.NotActivatedUserRepository;
import com.example.BloodBank.repository.UserRepository;
import com.example.BloodBank.service.service_interface.INotActivatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class NotActivatedUserService implements INotActivatedUserService {
    private final NotActivatedUserRepository notActivatedUserRepository;
    private final UserRepository userRepository;
    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    public NotActivatedUserService(NotActivatedUserRepository notActivatedUserRepository,
                                   UserRepository userRepository){
        this.notActivatedUserRepository = notActivatedUserRepository;
        this.userRepository = userRepository;
    }
    @Override
    public NotActivatedUser Create(NotActivatedUser entity) throws Exception {
        //check if username or email are taken by some user or notActivatedUser
        String uuid = UUID.randomUUID().toString();
        entity.setRole(Role.CUSTOMER);
        emailSenderService.sendSimpleEmail(entity.getEmail(), "Blood bank activation", "http://localhost:8086/activate/"+uuid);
        entity.setActivation(uuid);
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
        Optional<NotActivatedUser> user = notActivatedUserRepository.findByActivation(code);
        if(user.isPresent()){
            return user.get();
        } else {
            throw new EntityDoesntExistException();
        }
    }
    public Boolean Activate(String activationCode) throws Exception{
        NotActivatedUser notActivatedUser = ReadByActivationCode(activationCode);
        User newUser = makeUserFromNotActivated(notActivatedUser);
        userRepository.save(newUser);
        //delete not activated from base
        return true;
    }
    private Address createAddressFromNotActivated(NotActivatedUser user){
        Address add = new Address();
        if (user.getAddress() != null){
            add.setCountry(user.getAddress().getCountry());
            add.setCity(user.getAddress().getCity());
            add.setStreet(user.getAddress().getStreet());
            add.setNumber(user.getAddress().getNumber());
        }
        return add;
    }
    private User makeUserFromNotActivated(NotActivatedUser notActivatedUser){
        Address add = createAddressFromNotActivated(notActivatedUser);

        User newUser = new User();
        newUser.setUsername(notActivatedUser.getUsername());
        newUser.setPassword(notActivatedUser.getPassword());
        newUser.setEmail(notActivatedUser.getEmail());
//        newUser.setAddress(add);
        newUser.setDob(notActivatedUser.getDob());
        newUser.setGender(notActivatedUser.getGender());
        newUser.setRole(notActivatedUser.getRole());
        newUser.setFirstName(notActivatedUser.getFirstName());
        newUser.setLastName(notActivatedUser.getLastName());
        return  newUser;
    }
}

package com.example.BloodBank.service;

import com.example.BloodBank.repository.AddressRepository;
import com.example.BloodBank.repository.AdminRepository;
import com.example.BloodBank.service.service_interface.IAdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BloodBank.excpetions.EntityDoesntExistException;
import com.example.BloodBank.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService implements IAdminService {

    private final AdminRepository adminRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public AdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin Create(Admin entity){
        return adminRepository.save(entity);

    }

    @Override
    public Admin Read(Long id) throws Exception {
        Optional<Admin> admin = adminRepository.findById(id);
        if(admin.isPresent()){
            return admin.get();
        } else {
            throw new EntityDoesntExistException(id);
        }
    }

    @Override
    public Admin Update(Admin entity){
        return adminRepository.save(entity);
    }

    @Override
    public void Delete(Admin entity){
        adminRepository.delete(entity);
    }

    @Override
    public Iterable<Admin> GetAll() {
        return adminRepository.findAll();
    }

}

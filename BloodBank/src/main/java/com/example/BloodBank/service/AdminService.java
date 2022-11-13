package com.example.BloodBank.service;

import com.example.BloodBank.excpetions.EntityDoesntExistException;
import com.example.BloodBank.model.Admin;
import com.example.BloodBank.repository.AdminRepository;
import com.example.BloodBank.service.service_interface.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService implements IAdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    @Override
    public void Create(Admin entity){
        adminRepository.save(entity);
    }

    @Override
    public Admin Read(int id) throws Exception {
        Optional<Admin> admin = adminRepository.findById(Long.valueOf(id));
        if(admin.isPresent()){
            return admin.get();
        } else {
            throw new EntityDoesntExistException(id);
        }
    }

    @Override
    public void Update(Admin entity){
        adminRepository.save(entity);
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

package com.example.BloodBank.service;

import com.example.BloodBank.dto.RegistrationAdminDTO;
import com.example.BloodBank.model.BloodBank;
import com.example.BloodBank.repository.AdminRepository;
import com.example.BloodBank.service.service_interface.IAdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BloodBank.excpetions.EntityDoesntExistException;
import com.example.BloodBank.model.Admin;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AdminService implements IAdminService {

    private final AdminRepository adminRepository;
    private final BloodBankService bloodBankService;

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public AdminService(AdminRepository adminRepository, BloodBankService bloodBankService){
        this.adminRepository = adminRepository;
        this.bloodBankService = bloodBankService;
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

    @Transactional
    @Override
    public void registerAdmin(RegistrationAdminDTO registrationAdminDTO) {

        try{
            Admin admin = modelMapper.map(registrationAdminDTO, Admin.class);
            Optional<BloodBank> bank = bloodBankService.findByEmail(registrationAdminDTO.getBankEmail());
            if(!bank.isPresent())
                throw new IllegalStateException();
            admin.setBloodBank(bank.get());
            adminRepository.save(admin);
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new UnsupportedOperationException("Can't save admin!");
        }
    }
}

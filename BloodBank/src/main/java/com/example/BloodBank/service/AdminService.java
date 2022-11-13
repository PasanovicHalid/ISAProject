package com.example.BloodBank.service;

import com.example.BloodBank.repository.AddressRepository;
import com.example.BloodBank.repository.AdminRepository;
import com.example.BloodBank.repository.BloodBankRepository;
import com.example.BloodBank.repository.BloodRepository;
import com.example.BloodBank.service.service_interface.IAdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {
    private final AdminRepository adminRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
}

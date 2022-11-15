package com.example.BloodBank.service.service_interface;
import com.example.BloodBank.dto.RegistrationAdminDTO;
import com.example.BloodBank.model.Admin;

public interface IAdminService extends ICRUDService<Admin> {
    void registerAdmin(RegistrationAdminDTO registrationAdminDTO);
}

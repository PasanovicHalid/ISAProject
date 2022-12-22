package com.example.BloodBank.service.service_interface;
import com.example.BloodBank.dto.userDTOs.RegistrationAdminDTO;
import com.example.BloodBank.model.Admin;

public interface IAdminService extends ICRUDService<Admin> {

   // Optional<Admin> findByBloodBankId(long id);
    void registerAdmin(RegistrationAdminDTO registrationAdminDTO);
}

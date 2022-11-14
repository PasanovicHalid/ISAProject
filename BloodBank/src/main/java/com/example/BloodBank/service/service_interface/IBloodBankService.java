package com.example.BloodBank.service.service_interface;

import com.example.BloodBank.dto.BloodBankDTO;
import com.example.BloodBank.model.BloodBank;

import java.util.Optional;


public interface IBloodBankService extends ICRUDService<BloodBank> {
    boolean checkForBlood(String bankEmail, String bloodType, int quantity);
    void checkAPIKey(String bankEmail, String APIKey) throws IllegalAccessException;
    void registerBloodBank(BloodBankDTO bloodBank);
    Optional<BloodBank> findByEmail(String email);
}

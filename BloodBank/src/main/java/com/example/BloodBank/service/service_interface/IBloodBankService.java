package com.example.BloodBank.service.service_interface;

import com.example.BloodBank.dto.BloodBankDTO;
import com.example.BloodBank.model.BloodBank;
import org.springframework.data.domain.Pageable;

import java.util.List;

import java.util.Optional;


public interface IBloodBankService extends ICRUDService<BloodBank> {
    boolean checkForBlood(String bankEmail, String bloodType, int quantity);
    void checkAPIKey(String bankEmail, String APIKey) throws IllegalAccessException;
    void registerBloodBank(BloodBankDTO bloodBank);
    List<BloodBank> getAll() throws Exception;

    List<BloodBank> getBanksByRatingRange(String filter, Pageable page) throws Exception;

    List<BloodBank> getBanksByName(String filter, Pageable page) throws Exception;

    List<BloodBank> getBanksByAddress(String filter, Pageable page) throws Exception;

    Optional<BloodBank> findByEmail(String email);

    Integer sendBlood(String bankEmail, String bloodType, int quantity);
    Boolean savePDF(String bankEmail, byte[] pdf);
}

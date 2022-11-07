package com.example.BloodBank.service;

import com.example.BloodBank.dto.BloodBankDTO;
import com.example.BloodBank.model.BloodBank;
import com.example.BloodBank.repository.BloodBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.BlockingDeque;


@Service
public class BloodBankService {
    private final BloodBankRepository bloodBankRepository;

    @Autowired
    public BloodBankService(BloodBankRepository bloodBankRepository) {
        this.bloodBankRepository = bloodBankRepository;
    }

    public boolean checkForBlood(String bankEmail, String bloodType, int quantity){

        for(BloodBank bank : bloodBankRepository.findAll()){
            if(bank.getEmail().equals(bankEmail)){
                switch (bloodType) {
                    case "Aplus":
                        if(bank.getBlood().getAplus() == 0)
                            return false;
                        return bank.getBlood().getAplus() >= quantity;
                    case "ABplus":
                        if(bank.getBlood().getABplus() == 0)
                            return false;
                        return bank.getBlood().getABplus() >= quantity;
                    case "Bplus":
                        if(bank.getBlood().getBplus() == 0)
                            return false;
                        return bank.getBlood().getBplus() >= quantity;
                    case "Oplus":
                        if(bank.getBlood().getOplus() == 0)
                            return false;
                        return bank.getBlood().getOplus() >= quantity;
                    case "Aminus":
                        if(bank.getBlood().getAminus() == 0)
                            return false;
                        return bank.getBlood().getAminus() >= quantity;
                    case "ABminus":
                        if(bank.getBlood().getABminus() == 0)
                            return false;
                        return bank.getBlood().getABminus() >= quantity;
                    case "Bminus":
                        if(bank.getBlood().getBminus() == 0)
                            return false;
                        return bank.getBlood().getBminus() >= quantity;
                    case "Ominus":
                        if(bank.getBlood().getOminus() == 0)
                            return false;
                        return bank.getBlood().getOminus() >= quantity;
                }
            }
        }
        return false;
    }

    public void checkAPIKey(String bankEmail, String APIKey) throws IllegalAccessException {

        Optional<BloodBank> bank = bloodBankRepository.findByEmail(bankEmail);
        if(!bank.isPresent())
            throw new IllegalStateException("Bank with that kind of email doesn't exist!");

        if(APIKey.equals("") || !APIKey.contains(bank.get().getAPIKey()))
            throw new IllegalAccessException("Authorization failed!");
    }

    public void registerBloodBank(BloodBankDTO bloodBank){

    }
}

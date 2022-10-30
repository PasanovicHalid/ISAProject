package com.example.BloodBank.service;

import com.example.BloodBank.model.BloodBank;
import com.example.BloodBank.repository.BloodBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingDeque;

import static com.example.BloodBank.BloodBankApplication.bloodBanks;

@Service
public class BloodBankService {
    private final BloodBankRepository bloodBankRepository;

    @Autowired
    public BloodBankService(BloodBankRepository bloodBankRepository) {
        this.bloodBankRepository = bloodBankRepository;
    }

    public boolean checkForBlood(String bankEmail, String bloodType, int quantity){

        for(BloodBank bank : bloodBanks){
            if(bank.getEmail().equals(bankEmail)){
                switch (bloodType) {
                    case "Aplus":
                        if(bank.getAplus() == 0)
                            return false;
                        return bank.getAplus() >= quantity;
                    case "ABplus":
                        if(bank.getABplus() == 0)
                            return false;
                        return bank.getABplus() >= quantity;
                    case "Bplus":
                        if(bank.getBplus() == 0)
                            return false;
                        return bank.getBplus() >= quantity;
                    case "Oplus":
                        if(bank.getOplus() == 0)
                            return false;
                        return bank.getOplus() >= quantity;
                    case "Aminus":
                        if(bank.getAminus() == 0)
                            return false;
                        return bank.getAminus() >= quantity;
                    case "ABminus":
                        if(bank.getABminus() == 0)
                            return false;
                        return bank.getABminus() >= quantity;
                    case "Bminus":
                        if(bank.getBminus() == 0)
                            return false;
                        return bank.getBminus() >= quantity;
                    case "Ominus":
                        if(bank.getOminus() == 0)
                            return false;
                        return bank.getOminus() >= quantity;
                }
            }
        }
        return false;
    }
}

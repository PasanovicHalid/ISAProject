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
                        return bank.getAplus() > quantity;
                    case "ABplus":
                        return bank.getABplus() > quantity;
                    case "Bplus":
                        return bank.getBplus() > quantity;
                    case "Oplus":
                        return bank.getOplus() > quantity;
                    case "Aminus":
                        return bank.getAminus() > quantity;
                    case "ABminus":
                        return bank.getABminus() > quantity;
                    case "Bminus":
                        return bank.getBminus() > quantity;
                    case "Ominus":
                        return bank.getOminus() > quantity;
                }
            }
        }
        return false;
    }
}

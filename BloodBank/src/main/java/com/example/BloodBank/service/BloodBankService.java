package com.example.BloodBank.service;

import com.example.BloodBank.repository.BloodBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodBankService {
    private final BloodBankRepository bloodBankRepository;

    @Autowired
    public BloodBankService(BloodBankRepository bloodBankRepository) {
        this.bloodBankRepository = bloodBankRepository;
    }
}

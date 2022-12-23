package com.example.BloodBank.service;

import com.example.BloodBank.repository.HeadAdminRepository;
import com.example.BloodBank.service.service_interface.IHeadAdminService;
import org.springframework.beans.factory.annotation.Autowired;

public class HeadAdminService implements IHeadAdminService {
    private final HeadAdminRepository headAdminRepository;
    @Autowired
    public HeadAdminService(HeadAdminRepository headAdminRepository){
        this.headAdminRepository = headAdminRepository;
    }
}

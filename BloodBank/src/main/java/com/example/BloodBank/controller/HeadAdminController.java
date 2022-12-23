package com.example.BloodBank.controller;

import adapters.CustomerMapper;
import adapters.HeadAdminMapper;
import com.example.BloodBank.service.AdminService;
import com.example.BloodBank.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/head_admin")
@CrossOrigin(origins = "http://localhost:4200")
public class HeadAdminController {
    private final AdminService adminService;
    private final ModelMapper modelMapper;
    private HeadAdminMapper headAdminMapper;
    @Autowired
    public HeadAdminController(AdminService adminService, ModelMapper modelMapper){
        this.adminService = adminService;
        this.modelMapper = modelMapper;
        this.headAdminMapper = new HeadAdminMapper(modelMapper);
    }
}

package com.example.BloodBank.controller;

import com.example.BloodBank.dto.GetAdminDTO;
import com.example.BloodBank.excpetions.EntityDoesntExistException;
import com.example.BloodBank.model.Admin;
import com.example.BloodBank.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/admin")
public class AdminController {

    private final AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
public Admin FindById(GetAdminDTO getAdminDTO){
        try{
            return adminService.Read(getAdminDTO.getId());
        } catch (Exception e) {
            if(e instanceof EntityDoesntExistException){
                 new EntityDoesntExistException(getAdminDTO.getId());
            }
                throw new RuntimeException(e);
        }
}
}

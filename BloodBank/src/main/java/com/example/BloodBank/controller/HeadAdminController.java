package com.example.BloodBank.controller;

import adapters.CustomerMapper;
import adapters.HeadAdminMapper;
import com.example.BloodBank.dto.userDTOs.RegisterHeadAdminDTO;
import com.example.BloodBank.model.Customer;
import com.example.BloodBank.service.AdminService;
import com.example.BloodBank.service.CustomerService;
import com.example.BloodBank.service.HeadAdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/head_admin")
@CrossOrigin(origins = "http://localhost:4200")
public class HeadAdminController {
    private final HeadAdminService headAdminService;
    private final ModelMapper modelMapper;
    private HeadAdminMapper headAdminMapper;
    @Autowired
    public HeadAdminController(HeadAdminService adminService, ModelMapper modelMapper){
        this.headAdminService = adminService;
        this.modelMapper = modelMapper;
        this.headAdminMapper = new HeadAdminMapper(modelMapper);
    }
    @PostMapping(consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<Object> registerHeadAdmin(@Valid @RequestBody RegisterHeadAdminDTO headAdminDTO){
        try {
            headAdminService.registerHeadAdmin(headAdminMapper.fromDTO(headAdminDTO));
            return new ResponseEntity<>(true,
                                HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

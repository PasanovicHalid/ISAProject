package com.example.BloodBank.controller;

import com.example.BloodBank.dto.AppointmentExecuteDTO;
import com.example.BloodBank.service.AppointmentExecuteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/appointmentExecute")
public class AppointmentExecuteController {

    private  final AppointmentExecuteService appointmentExecuteService;

    private final ModelMapper modelMapper;

    @Autowired
    public AppointmentExecuteController(AppointmentExecuteService appointmentExecuteService, ModelMapper modelMapper) {
        this.appointmentExecuteService = appointmentExecuteService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<Object> Create(@RequestBody AppointmentExecuteDTO appointmentExecuteDTO){
        try{
            appointmentExecuteService.makeAppointmentExecute(appointmentExecuteDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}

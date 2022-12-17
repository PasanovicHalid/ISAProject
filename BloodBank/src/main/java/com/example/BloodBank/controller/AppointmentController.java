package com.example.BloodBank.controller;

import adapters.AppointmentMapper;
import com.example.BloodBank.dto.AppointmentDTO;
import com.example.BloodBank.model.Appointment;
import com.example.BloodBank.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(path = "api/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    private static AppointmentMapper appointmentMapper;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, ModelMapper modelMapper) {
        this.appointmentService = appointmentService;
        this.appointmentMapper = new AppointmentMapper(modelMapper);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> read(@PathVariable("id") long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(appointmentService.Read(id));
        } catch (Exception e){
            if(e instanceof EntityNotFoundException){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping(value = "/pageable")
    public ResponseEntity<Object> getAllPagable() {
        return null;
    }

    @GetMapping()
    public ResponseEntity<Object> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body( appointmentService.GetAll());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

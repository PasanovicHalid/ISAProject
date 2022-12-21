package com.example.BloodBank.controller;

import adapters.AppointmentMapper;
import com.example.BloodBank.dto.AppointmentDTO;
import com.example.BloodBank.dto.AppointmentViewDTO;
import com.example.BloodBank.dto.BookAppointmentDTO;
import com.example.BloodBank.model.Appointment;
import com.example.BloodBank.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<Object> getAllPagable(@RequestParam String startDate, @RequestParam String startTime, Pageable page) {
        try {
            Page<Appointment> appointments = appointmentService.GetAllPageable(page);
            PageImpl<AppointmentViewDTO> result = new PageImpl<>(appointments.getContent().stream().map(AppointmentMapper::toAppointmentViewDTO).collect(Collectors.toList()),
            page, appointments.getTotalElements());
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<Object> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(appointmentService.GetAll());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(value = "/book")
    public ResponseEntity<Object> bookAppointment(@RequestParam BookAppointmentDTO dto){
        try {
            appointmentService.BookAppointment(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

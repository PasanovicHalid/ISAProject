package com.example.BloodBank.controller;

import adapters.AppointmentMapper;
import com.example.BloodBank.dto.AppointmentDTO;
import com.example.BloodBank.exceptions.EntityDoesntExistException;
import com.example.BloodBank.model.Appointment;
import com.example.BloodBank.model.Customer;
import com.example.BloodBank.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    private static AppointmentMapper appointmentMapper;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, ModelMapper modelMapper, ModelMapper modelMapper1) {
        this.appointmentService = appointmentService;
        this.appointmentMapper = new AppointmentMapper(modelMapper);
    }

    @GetMapping(path="customer")
    public ResponseEntity<Object> readByCustomerId(@RequestParam("id") Optional<Long> id) {
        try {
            List<Appointment> appointments =(List<Appointment>)  appointmentService.GetByCustomerId(Long.valueOf(id.get()));
            return new  ResponseEntity<>(appointmentMapper.toAppointmentDTOList(appointments), HttpStatus.OK);
        } catch (Exception e){
            if(e instanceof EntityNotFoundException){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
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


    @PostMapping(path ="byAdmin",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> Update(@RequestBody AppointmentDTO appointmentDTO){
        try{
            Appointment appointment = appointmentMapper.fromAppointmentDTO(appointmentDTO);
           // appointment.setLocation(appointmentService.Read(appointment.getId()).getLocation());
            appointment.setVersion(appointmentService.Read(appointment.getId()).getVersion());
            appointmentService.Update(appointment);
            return ResponseEntity.status(HttpStatus.OK).body(appointmentService.Read(appointment.getId()));

        }catch (Exception e){
            System.out.println(e.getMessage());
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

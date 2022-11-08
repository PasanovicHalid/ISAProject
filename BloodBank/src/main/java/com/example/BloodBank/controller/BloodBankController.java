package com.example.BloodBank.controller;

import com.example.BloodBank.dto.BloodBankDTO;
import com.example.BloodBank.model.BloodBank;
import com.example.BloodBank.model.Gender;
import com.example.BloodBank.model.Role;
import com.example.BloodBank.model.User;
import com.example.BloodBank.service.BloodBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "api/bloodbank")
public class BloodBankController {
    private final BloodBankService bloodBankService;

    @Autowired
    public BloodBankController(BloodBankService bloodBankService) {
        this.bloodBankService = bloodBankService;
    }

//    @GetMapping//(produces = MediaType.APPLICATION_JSON_VALUE)
//    public User hello(){
//        System.out.println("e tu smo");
//        String hello = "Hello from back!";
//        User user = new User("Ana", "Ana", "ana", "ana", "ana", Gender.FEMALE,LocalDate.of(2000,5,5), Role.ADMIN);
//        return user;
//
    @GetMapping//(produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello(){
        System.out.println("e tu smo");
        return "Hello from back!" ;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "{bankEmail}/{bloodType}/{quantity}")
    public ResponseEntity<Boolean> fromPSW(@PathVariable("bankEmail") String bankEmail,
                                          @PathVariable("bloodType") String bloodType,
                                          @PathVariable("quantity") int quantity,
                                            @RequestHeader(name = HttpHeaders.AUTHORIZATION) String APIkey){

        try{
            bloodBankService.checkAPIKey(bankEmail, APIkey);
        }
        catch(Exception e){
            if(e.toString().contains("IllegalStateException"))
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        return ResponseEntity.status(HttpStatus.OK).body(bloodBankService.checkForBlood(bankEmail, bloodType, quantity));
    }
    @PostMapping
    public ResponseEntity<Object> registerBloodBank(@Valid @RequestBody BloodBankDTO bloodBankDTO, BindingResult bindingResult){

//        try{
//            bloodBankService.registerBloodBank(bloodBankDTO);
//            return HttpStatus.OK;
//        }
//        catch(Exception e){
//            return HttpStatus.NOT_FOUND;
//        }
        if(bindingResult.hasErrors()){
            System.err.println("error!");
            Map<String, String> errors = new HashMap<>();
            for (FieldError error:bindingResult.getFieldErrors()){
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

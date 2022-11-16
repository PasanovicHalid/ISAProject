package com.example.BloodBank.controller;

import com.example.BloodBank.dto.BloodBankDTO;
import com.example.BloodBank.model.*;
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
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "api/bloodbank")
public class BloodBankController {
    private final BloodBankService bloodBankService;

    @Autowired
    public BloodBankController(BloodBankService bloodBankService) {
        this.bloodBankService = bloodBankService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BloodBankDTO>> getAll(){

        try{
            List<BloodBankDTO> bloodBanks = bloodBankService.GetBanksAsDTO();
           return new ResponseEntity<>(bloodBanks, HttpStatus.OK);
        }
        catch(Exception e){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
    @GetMapping()
    public ResponseEntity<List<BloodBank>> getAllBloodBank() {
        try {
            System.out.println("in getAllBloodBank()");
            return new ResponseEntity<>(bloodBankService.getAll(),HttpStatus.OK) ;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Object> registerBloodBank(@Valid @RequestBody BloodBankDTO bloodBankDTO, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            System.err.println("error!");
            Map<String, String> errors = new HashMap<>();
            for (FieldError error:bindingResult.getFieldErrors()){
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }
        try{
            bloodBankService.registerBloodBank(bloodBankDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "{bankEmail}")
    public ResponseEntity<Boolean> getBloodReportsFromPSW(@RequestBody byte[] pdf,
                                                          @PathVariable("bankEmail") String bankEmail,
                                                          @RequestHeader(name = HttpHeaders.AUTHORIZATION) String APIkey){


        try{
            System.out.println("Got it");
            System.out.println(pdf);
            bloodBankService.checkAPIKey(bankEmail, APIkey);
            LocalDateTime today = LocalDateTime.now();

            String formattedDate = today.format(DateTimeFormatter.ofPattern("ddMMyyyy_hhmmss"));
            try (FileOutputStream fos = new FileOutputStream("D://Faks//3. Internet softverske arhitekture//PROJEKAT_ISA//ISAProject//BloodBank/src/report_" + formattedDate + ".pdf")) {
                fos.write(pdf);
                //fos.close // no need, try-with-resources auto close
            }
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

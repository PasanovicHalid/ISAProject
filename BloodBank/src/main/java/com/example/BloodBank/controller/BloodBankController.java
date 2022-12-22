package com.example.BloodBank.controller;

import adapters.BloodBankMapper;
import com.example.BloodBank.dto.BloodBankDTO;
import com.example.BloodBank.dto.PagableRequestDTO;
import com.example.BloodBank.model.*;
import com.example.BloodBank.service.BloodBankService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "api/bloodbank")
@CrossOrigin(origins = "http://localhost:4200")
public class BloodBankController {
    private final BloodBankService bloodBankService;

    private final ModelMapper modelMapper;

    private static BloodBankMapper bloodBankMapper;

    @Autowired
    public BloodBankController(BloodBankService bloodBankService, ModelMapper modelMapper) {
        this.bloodBankService = bloodBankService;
        this.modelMapper = modelMapper;
        bloodBankMapper = new BloodBankMapper(modelMapper);
    }

    @CrossOrigin("http://localhost:4200")
//    @PreAuthorize("hasRole('ROLE_HEADADMIN')")
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BloodBankDTO>> getAllPaginate(@Valid @RequestBody PagableRequestDTO request){
        try{
            Pageable page;
            if(request.getSortColumn().isEmpty()){
                page = PageRequest.of(request.getPageIndex(), request.getPageSize());
            } else {
                if(request.getSortDirection().toLowerCase().equals("desc")){
                    page = PageRequest.of(request.getPageIndex(), request.getPageSize(), Sort.by(request.getSortColumn()).descending());
                } else if(request.getSortDirection().toLowerCase().equals("asc")){
                    page = PageRequest.of(request.getPageIndex(), request.getPageSize(), Sort.by(request.getSortColumn()).ascending());
                } else {
                    page = PageRequest.of(request.getPageIndex(), request.getPageSize());
                }
            }
            List<BloodBankDTO> bloodBanks = new ArrayList<>();
            switch (request.getFilterType()){
                case RATING:
                    bloodBanks = bloodBankMapper.toBloodBankDTOList(bloodBankService.getBanksByRatingRange(request.getFilter(), page));
                    break;
                case DISTANCE:
                    break;
                case NAME_SEARCH:
                    bloodBanks = bloodBankMapper.toBloodBankDTOList(bloodBankService.getBanksByName(request.getFilter(), page));
                    break;
                case ADDRESS_SEARCH:
                    bloodBanks = bloodBankMapper.toBloodBankDTOList(bloodBankService.getBanksByAddress(request.getFilter(), page));
                    break;
                default:
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(bloodBanks, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin("http://localhost:4200")
    @PreAuthorize("hasRole('ROLE_HEADADMIN')")
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

    @CrossOrigin("http://localhost:4200")
    @PreAuthorize("hasRole('ROLE_HEADADMIN')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "{bankEmail}/{bloodType}/{quantity}")
    public ResponseEntity<Boolean> checkBloodAvailability(@PathVariable("bankEmail") String bankEmail,
                                          @PathVariable("bloodType") String bloodType,
                                          @PathVariable("quantity") int quantity,
                                            @RequestHeader(name = HttpHeaders.AUTHORIZATION) String APIkey){

        try{
            bloodBankService.checkAPIKey(bankEmail, APIkey);
            Boolean b = bloodBankService.checkForBlood(bankEmail, bloodType, quantity);
            return ResponseEntity.status(HttpStatus.OK).body(b);
        }
        catch(Exception e){
            if(e.toString().contains("IllegalStateException"))
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @CrossOrigin("http://localhost:4200")
    @PreAuthorize("hasRole('ROLE_HEADADMIN')")
    @GetMapping(path = "/allBloodBanks")
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
            bloodBankService.checkAPIKey(bankEmail, APIkey);
            return new ResponseEntity<>(bloodBankService.savePDF(bankEmail, pdf), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin("http://localhost:4200")
    @PreAuthorize("hasRole('ROLE_HEADADMIN')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "get/{bankEmail}/{bloodType}/{quantity}")
    public ResponseEntity<Integer> sendBlood(@PathVariable("bankEmail") String bankEmail,
                                                          @PathVariable("bloodType") String bloodType,
                                                          @PathVariable("quantity") int quantity,
                                                          @RequestHeader(name = HttpHeaders.AUTHORIZATION) String APIkey){

        try{
            bloodBankService.checkAPIKey(bankEmail, APIkey);
            return ResponseEntity.status(HttpStatus.OK).body(bloodBankService.sendBlood(bankEmail, bloodType, quantity));
        }
        catch(Exception e){
            if(e.toString().contains("IllegalStateException"))
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else if(e.toString().contains("UnsupportedOperationException"))
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }


    }
}

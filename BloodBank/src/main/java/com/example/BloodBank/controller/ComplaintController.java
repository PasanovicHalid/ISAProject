package com.example.BloodBank.controller;

import com.example.BloodBank.dto.RegistrationAdminDTO;
import com.example.BloodBank.dto.UserDTO;
import com.example.BloodBank.service.AdminService;
import com.example.BloodBank.service.ComplaintService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "api/complaint")
public class ComplaintController {

    private final ComplaintService complaintService;
    private final ModelMapper modelMapper;

    @Autowired
    public ComplaintController(ComplaintService complaintService, ModelMapper modelMapper) {

        this.complaintService = complaintService;
        this.modelMapper = modelMapper;
    }

    
//    @Operation(summary = "Create a complaint", description = "Create a complaint")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Complaint successfully created",
//                    content =
//                            { @Content(mediaType = "application/json", schema = @Schema(implementation = ComplaintDTO.class)) }
//            )
//            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
//    @PostMapping
//    public ResponseEntity<Object> createComplaint(@Valid @RequestBody ComplaintDTO complaintDTO){
//
//        if(bindingResult.hasErrors()){
//            System.err.println("error!");
//            Map<String, String> errors = new HashMap<>();
//            for (FieldError error:bindingResult.getFieldErrors()){
//                errors.put(error.getField(), error.getDefaultMessage());
//            }
//            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
//        }
//        try{
//            adminService.registerAdmin(registrationAdminDTO);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        catch(Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
}

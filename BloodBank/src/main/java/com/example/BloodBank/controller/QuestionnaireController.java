package com.example.BloodBank.controller;

import com.example.BloodBank.dto.QuestionnaireDTO;
import com.example.BloodBank.exceptions.QuestionnaireForCustomerDoesntExist;
import com.example.BloodBank.model.Questionnaire;
import com.example.BloodBank.service.CustomerService;
import com.example.BloodBank.service.QuestionnaireService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping(path = "api/questionnaire")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionnaireController {
    private final QuestionnaireService questionnaireService;

    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    public QuestionnaireController(QuestionnaireService questionnaireService, CustomerService customerService, ModelMapper modelMapper) {
        this.questionnaireService = questionnaireService;
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }
    @GetMapping()
    public ResponseEntity<Iterable<Questionnaire>> getAllQuestionnaires(){
        try {
            return new ResponseEntity<>(questionnaireService.GetAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/specific")
    public ResponseEntity<Object> getQuestionnaireOfCustomer(@RequestParam long customerId){
        try {
            Questionnaire questionnaire = questionnaireService.getForCustomer(customerId);
            QuestionnaireDTO questionnaireDTO = modelMapper.map(questionnaire,QuestionnaireDTO.class);
            questionnaireDTO.setCustomerId(String.valueOf(questionnaire.getCustomer().getId()));
            return ResponseEntity.status(HttpStatus.OK).body(questionnaireDTO);
        } catch (QuestionnaireForCustomerDoesntExist e) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
//    @PreAuthorize("hasRole('ROLE_HEADADMIN')")
    @PostMapping(
            value = "/create", consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<Object> createQuestionnaire(@Valid @RequestBody QuestionnaireDTO newQuestionnaire){
        try {
            questionnaireService.CreateDTO(newQuestionnaire);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(
            value = "/update", consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<Object> updateQuestionnaire(@Valid @RequestBody QuestionnaireDTO questionnaireDTO){
        try {
            if(questionnaireDTO == null){
                return new ResponseEntity<>("Questionnaire is null",HttpStatus.BAD_REQUEST);
            }

            Questionnaire questionnaire = modelMapper.map(questionnaireDTO, Questionnaire.class);

            Questionnaire questionnaireFromDB = questionnaireService.Read(questionnaireDTO.getId());
            if(questionnaireFromDB == null){
                return new ResponseEntity<>("Questionnaire doesn't exist",HttpStatus.BAD_REQUEST);
            }

            questionnaire.setCustomer(questionnaireFromDB.getCustomer());
            questionnaire.setFillDate(LocalDate.now());

            questionnaireService.Update(questionnaire);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(
            value = "/create_not_present", consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<Object> createQuestionnaireWhenNotPresent(@Valid @RequestBody QuestionnaireDTO questionnaireDTO){
        try {
            try{
                Questionnaire questionnaireFromDB = questionnaireService.getForCustomer(Long.valueOf(questionnaireDTO.getCustomerId()));
                return new ResponseEntity<>("Questionnaire already exists", HttpStatus.BAD_REQUEST);
            } catch (Exception ignored){}
            Questionnaire questionnaire = modelMapper.map(questionnaireDTO, Questionnaire.class);
            questionnaire.setId(null);
            questionnaire.setCustomer(customerService.Read(Long.valueOf(questionnaireDTO.getCustomerId())));
            questionnaire.setFillDate(LocalDate.now());
            questionnaireService.Create(questionnaire);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/check")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public ResponseEntity<Object> checkQuestionnaire(@RequestParam long customerId){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(questionnaireService.checkQuestionnaire(customerId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping(value = "/getAll")
    public  ResponseEntity<Object> getAll(){
        try{
            return new ResponseEntity<>(questionnaireService.GetAll(), HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

package com.example.BloodBank.controller;

import com.example.BloodBank.model.Questionnaire;
import com.example.BloodBank.service.QuestionnaireService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/questionnaire")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionnaireController {
    private final QuestionnaireService questionnaireService;
    private final ModelMapper modelMapper;

    public QuestionnaireController(QuestionnaireService questionnaireService, ModelMapper modelMapper) {
        this.questionnaireService = questionnaireService;
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
    @CrossOrigin(origins = "http://localhost:4200")
//    @PreAuthorize("hasRole('ROLE_HEADADMIN')")
    @PostMapping(
            value = "/create", consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<Object> createQuestionnaire(@Valid @RequestBody Questionnaire newQuestionnaire){
        try {
            questionnaireService.Create(newQuestionnaire);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

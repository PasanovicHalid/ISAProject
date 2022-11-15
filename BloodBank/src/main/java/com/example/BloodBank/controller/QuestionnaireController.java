package com.example.BloodBank.controller;

import com.example.BloodBank.model.Questionnaire;
import com.example.BloodBank.service.QuestionnaireService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

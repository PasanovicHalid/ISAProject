package com.example.BloodBank.exceptions;

public class QuestionnaireForCustomerDoesntExist extends Exception {
    public QuestionnaireForCustomerDoesntExist() {
        super("Questionnaire doesn't exist");
    }
}

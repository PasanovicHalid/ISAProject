package com.example.BloodBank.service.service_interface;

import com.example.BloodBank.model.Questionnaire;

public interface IQuestionnaireService extends ICRUDService<Questionnaire> {

    boolean checkQuestionnaire(long id);
}

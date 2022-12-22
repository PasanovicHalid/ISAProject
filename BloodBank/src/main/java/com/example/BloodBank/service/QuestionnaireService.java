package com.example.BloodBank.service;

import com.example.BloodBank.exceptions.EntityDoesntExistException;
import com.example.BloodBank.model.Questionnaire;
import com.example.BloodBank.repository.QuestionnaireRepository;
import com.example.BloodBank.service.service_interface.IQuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
@Service
public class QuestionnaireService implements IQuestionnaireService {
    private final QuestionnaireRepository questionnaireRepository;

    @Autowired
    public QuestionnaireService(QuestionnaireRepository questionnaireRepository) { this.questionnaireRepository = questionnaireRepository;}

    @Override
    public Questionnaire Create(Questionnaire entity) throws Exception {
        return questionnaireRepository.save(entity);
    }

    @Override
    public Questionnaire Read(Long id) throws Exception {
        Optional<Questionnaire> questionnaire = questionnaireRepository.findById(id);
        if(questionnaire.isPresent()){
            return questionnaire.get();
        } else {
            throw new EntityDoesntExistException(id);
        }
    }

    @Override
    public Questionnaire Update(Questionnaire entity) throws Exception {
        //NOT NEEDED AT THE MOMENT
//        Optional<Questionnaire> questionnaire = questionnaireRepository.findById(entity.getId());
//        if(questionnaire.isPresent()){
//            Questionnaire temp = questionnaire.get();
//            temp.up
//
//            return questionnaireRepository.save(temp);
//        }
        return null;
    }

    @Override
    public void Delete(Questionnaire entity) throws Exception {
        questionnaireRepository.delete(entity);
    }

    @Override
    public Iterable<Questionnaire> GetAll() throws Exception {
        return questionnaireRepository.findAll();
    }

    @Override
    public boolean checkQuestionnaire(long id) {
        Questionnaire questionnaire = questionnaireRepository.findByCustomerId(id);
        if(questionnaire == null){
            return false;
        }
        return questionnaire.checkIfValidForReservationOfAppointment();
    }
}

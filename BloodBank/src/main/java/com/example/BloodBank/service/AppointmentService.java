package com.example.BloodBank.service;

import com.example.BloodBank.dto.BookAppointmentDTO;
import com.example.BloodBank.model.Appointment;
import com.example.BloodBank.model.AppointmentStatus;
import com.example.BloodBank.repository.AppointmentRepository;
import com.example.BloodBank.repository.CustomerRepository;
import com.example.BloodBank.service.service_interface.IAppointmentService;
import com.example.BloodBank.service.service_interface.IQuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class AppointmentService implements IAppointmentService {

    private final AppointmentRepository appointmentRepository;

    private final IQuestionnaireService questionnaireService;
    private final CustomerRepository customerRepository;


    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository,
                              IQuestionnaireService questionnaireService, CustomerRepository customerRepository) {
        this.appointmentRepository = appointmentRepository;
        this.questionnaireService = questionnaireService;
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional(readOnly = false)
    public Appointment Create(Appointment entity) throws Exception {
        return appointmentRepository.save(entity);
    }

    @Override
    public Appointment Read(Long id) throws Exception {
        return appointmentRepository.findById(id).get();
    }

    @Override
    @Transactional(readOnly = false)
    public Appointment Update(Appointment entity) throws Exception {
        return appointmentRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void Delete(Appointment entity) throws Exception {
        appointmentRepository.delete(entity);
    }

    @Override
    public Iterable<Appointment> GetAll() throws Exception {
        return appointmentRepository.findAll();
    }

    public Page<Appointment> GetAllPageable(Pageable page) throws Exception {
        return appointmentRepository.findAllAvailable(page);
    }
    @Transactional(readOnly = false)
    public Boolean BookAppointment(BookAppointmentDTO dto) throws Exception {
        Appointment appointment = appointmentRepository.findById(dto.appointmentId).orElseThrow();
        //check if appointment is free
        if(appointment.getExecuted() != AppointmentStatus.FREE){
            throw new Exception("Appointment is not free");
        }
        //check if customer filled questionnaire
        if(!questionnaireService.checkQuestionnaire(dto.customerId)){
            throw new Exception("Invalid questionnaire");
        }
        //check if customer donated blood in last 6 months
        List<Appointment> appointmentList = appointmentRepository.findAllAppointmentsIn6MonthPeriod(dto.customerId, Date.valueOf(LocalDate.now().minusMonths(6)));
        if(!appointmentList.isEmpty()){
            throw new Exception("Already did a blood extraction in a 6 month period");
        }
        //book appointment
        appointment.setExecuted(AppointmentStatus.PENDING);
        appointment.setTakenBy(customerRepository.findById(dto.customerId).orElseThrow());
        appointmentRepository.save(appointment);
        //send verification

        return true;
    }
}

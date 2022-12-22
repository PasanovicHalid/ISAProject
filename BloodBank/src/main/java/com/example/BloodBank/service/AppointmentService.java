package com.example.BloodBank.service;

import com.example.BloodBank.model.Appointment;
import com.example.BloodBank.model.AppointmentStatus;
import com.example.BloodBank.repository.AppointmentRepository;
import com.example.BloodBank.service.service_interface.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class AppointmentService implements IAppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
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
        if(entity.getExecuted() == AppointmentStatus.CANCELLED){
            //TODO: dodati penal
            entity.setTakenBy(appointmentRepository.findById(entity.getId()).get().getTakenBy());
            entity.setLocation(appointmentRepository.findById(entity.getId()).get().getLocation());
            entity.setVersion(appointmentRepository.findById(entity.getId()).get().getVersion());
            return appointmentRepository.save(entity);
        }else{
            return appointmentRepository.save(entity);
        }
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

    @Override
    public Iterable<Appointment> GetByCustomerId(Long id) throws Exception {
        List<Appointment> retVal = new ArrayList<>();
        Iterable<Appointment> appointments = appointmentRepository.findAll();
        for(Appointment appointment : appointments) {
            Long aId = appointment.getTakenBy().getId();
            boolean isTrue = aId.equals(id);
            if(isTrue){
                retVal.add(appointment);
            }
        }
        return  retVal;
    }

    public Page<Appointment> GetAllPageable(Pageable page) throws Exception {
        return appointmentRepository.findAll(page);
    }
}

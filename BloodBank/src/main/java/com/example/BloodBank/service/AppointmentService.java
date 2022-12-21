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
        return appointmentRepository.findAll(page);
    }

    @Override
    public List<Appointment> getDoneAndPendingAppointmentsForBloodBank(Long bankId) {
        List<Appointment> appointments = appointmentRepository.findAll();
        List<Appointment> doneAndPendingApp = new ArrayList<Appointment>();
        for(Appointment a : appointments){
            if((a.getExecuted().equals(AppointmentStatus.DONE) || a.getExecuted().equals(AppointmentStatus.PENDING))
                    && a.getLocation().getBankID() == bankId)
                doneAndPendingApp.add(a);
        }
        return doneAndPendingApp;
//        return null;
    }
}

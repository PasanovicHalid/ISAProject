package com.example.BloodBank.service;

import com.example.BloodBank.dto.AppointmentExecuteDTO;
import com.example.BloodBank.model.AppointmentExecute;
import com.example.BloodBank.repository.AppointmentExecuteRepository;
import com.example.BloodBank.service.service_interface.IAppointmentExecuteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AppointmentExecuteService implements IAppointmentExecuteService {

    private final AppointmentExecuteRepository appointmentExecuteRepository;

    ModelMapper modelMapper = new ModelMapper();

    public AppointmentExecuteService(AppointmentExecuteRepository appointmentExecuteRepository) {
        this.appointmentExecuteRepository = appointmentExecuteRepository;
    }


    @Override
    @Transactional(readOnly = false)
    public AppointmentExecute Create(AppointmentExecute entity) throws Exception {
        return null;
    }

    @Override
    public AppointmentExecute Read(Long id) throws Exception {
        return appointmentExecuteRepository.findById(id).get();
    }

    @Override
    public AppointmentExecute Update(AppointmentExecute entity) throws Exception {
        return appointmentExecuteRepository.save(entity);
    }

    @Override
    public void Delete(AppointmentExecute entity) throws Exception {
        appointmentExecuteRepository.delete(entity);
    }

    @Override
    public Iterable<AppointmentExecute> GetAll() throws Exception {
        return appointmentExecuteRepository.findAll();
    }

    @Override
    public AppointmentExecute makeAppointmentExecute(AppointmentExecuteDTO appointmentExecuteDTO) {
        AppointmentExecute appointmentExecute = modelMapper.map(appointmentExecuteDTO, AppointmentExecute.class);
        return appointmentExecuteRepository.save(appointmentExecute);
    }
}

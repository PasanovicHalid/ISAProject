package com.example.BloodBank.service.service_interface;

import com.example.BloodBank.model.Appointment;
import com.example.BloodBank.model.BloodBank;

import java.util.List;

public interface IAppointmentService extends ICRUDService<Appointment> {
    Iterable<Appointment> GetByCustomerId(Long id) throws Exception;

    List<Appointment> getDoneAndPendingAppointmentsForBloodBank(Long bankId);
}

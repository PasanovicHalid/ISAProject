package com.example.BloodBank.service.service_interface;

import com.example.BloodBank.model.Appointment;

public interface IAppointmentService extends ICRUDService<Appointment> {
    Iterable<Appointment> GetByCustomerId(Long id) throws Exception;
}

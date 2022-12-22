package com.example.BloodBank.service.service_interface;

import com.example.BloodBank.model.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.sql.Time;

public interface IAppointmentService extends ICRUDService<Appointment> {

    Page<Appointment> GetAllPageableFreeDateFilter(Pageable page, Date startDate, Time startTime) throws Exception;
}

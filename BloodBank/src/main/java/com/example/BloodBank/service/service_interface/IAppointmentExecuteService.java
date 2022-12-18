package com.example.BloodBank.service.service_interface;

import com.example.BloodBank.dto.AppointmentExecuteDTO;
import com.example.BloodBank.model.AppointmentExecute;

public interface IAppointmentExecuteService extends ICRUDService<AppointmentExecute> {

    AppointmentExecute makeAppointmentExecute(AppointmentExecuteDTO appointmentExecuteDTO);
}

package com.example.BloodBank.dto;

import com.example.BloodBank.model.Blood;

public class AppointmentExecuteDTO {
    private AppointmentDTO appointment;
    private boolean isExecute;

    private  int bloodQuantity;

    public void setAppointment(AppointmentDTO appointment) {
        this.appointment = appointment;
    }

    public void setExecute(boolean execute) {
        isExecute = execute;
    }

    public AppointmentDTO getAppointment() {
        return appointment;
    }

    public boolean isExecute() {
        return isExecute;
    }

    public AppointmentExecuteDTO() {
    }

    public AppointmentExecuteDTO(AppointmentDTO appointment, boolean isExecute) {
        this.appointment = appointment;
        this.isExecute = isExecute;
    }
}

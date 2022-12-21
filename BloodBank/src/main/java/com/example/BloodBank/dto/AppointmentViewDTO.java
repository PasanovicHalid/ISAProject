package com.example.BloodBank.dto;

import java.sql.Date;
import java.sql.Time;

public class AppointmentViewDTO {

    private long id;

    private Date appointmentDate;

    private Time startTime;

    private Time endTime;

    private BloodBankAppointmentViewDTO bloodBank;

    public AppointmentViewDTO(long id, Date appointmentDate, Time startTime, Time endTime, BloodBankAppointmentViewDTO bloodBank) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bloodBank = bloodBank;
    }

    public AppointmentViewDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public BloodBankAppointmentViewDTO getBloodBank() {
        return bloodBank;
    }

    public void setBloodBank(BloodBankAppointmentViewDTO bloodBank) {
        this.bloodBank = bloodBank;
    }
}

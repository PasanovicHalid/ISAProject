package com.example.BloodBank.dto;

import java.sql.Date;
import java.sql.Time;

public class AppointmentDTO {
    private long id;

    private Date appointmentDate;

    private Time startTime;

    private Time endTime;

    private CustomerDTO takenBy;

    private BloodBankDTO location;

    public AppointmentDTO(long id, Date appointmentDate, Time startTime, Time endTime, CustomerDTO takenBy, BloodBankDTO location) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.takenBy = takenBy;
        this.location = location;
    }

    public AppointmentDTO() {
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

    public CustomerDTO getTakenBy() {
        return takenBy;
    }

    public void setTakenBy(CustomerDTO takenBy) {
        this.takenBy = takenBy;
    }

    public BloodBankDTO getLocation() {
        return location;
    }

    public void setLocation(BloodBankDTO location) {
        this.location = location;
    }
}

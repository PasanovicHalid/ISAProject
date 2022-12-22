package com.example.BloodBank.dto.appointmentDTOs;

import java.sql.Date;
import java.sql.Time;

public class AppointmentCreationDTO {

    private long bankID;
    private Date date;

    private Time start;

    private Time end;

    public AppointmentCreationDTO() {
    }

    public AppointmentCreationDTO(Date date, Time start, Time end, long bankID) {
        this.date = date;
        this.start = start;
        this.end = end;
        this.bankID = bankID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public long getBankID() {
        return bankID;
    }

    public void setBankID(long bankID) {
        this.bankID = bankID;
    }
}

package com.example.BloodBank.dto.appointmentDTOs;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

public class CalendarAppointmentDTO {
    @NotNull
    @NotBlank
    private long id;
    @NotNull
    private LocalDateTime start;
    @NotNull
    private LocalDateTime end;
    @NotNull
    @NotBlank
    private String title;

    public CalendarAppointmentDTO() {
    }

    public CalendarAppointmentDTO(long id, LocalDateTime startTime, LocalDateTime endTime, String customerName) {
        this.id = id;
        this.start = startTime;
        this.end = endTime;
        this.title = customerName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

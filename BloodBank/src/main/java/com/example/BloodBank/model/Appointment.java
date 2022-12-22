package com.example.BloodBank.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date appointmentDate;
    private String comment;
    private Time startTime;

    private TypeOfBlood typeOfBlood;



    private int quantityOfBlood;
    private Time endTime;

    @Column(nullable = false)
    private AppointmentStatus executed;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = true)
    private Customer takenBy;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "bloodBank_id", referencedColumnName = "bankID", nullable = false)
    private BloodBank location;

    @Version
    @Column(columnDefinition = "integer DEFAULT 0", nullable = false)
    private Integer version;


    public Appointment(long id, Date appointmentDate, Time startTime, Time endTime, Customer takenBy, BloodBank location, AppointmentStatus status) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.takenBy = takenBy;
        this.location = location;
        this.executed = status;
    }

    public Appointment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public TypeOfBlood getTypeOfBlood() {
        return typeOfBlood;
    }

    public void setTypeOfBlood(TypeOfBlood typeOfBlood) {
        this.typeOfBlood = typeOfBlood;
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

    public int getQuantityOfBlood() {
        return quantityOfBlood;
    }

    public void setQuantityOfBlood(int quantityOfBlood) {
        this.quantityOfBlood = quantityOfBlood;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }




    public Customer getTakenBy() {
        return takenBy;
    }

    public void setTakenBy(Customer takenBy) {
        this.takenBy = takenBy;
    }

    public BloodBank getLocation() {
        return location;
    }

    public void setLocation(BloodBank location) {
        this.location = location;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public AppointmentStatus getExecuted() {
        return executed;
    }

    public void setExecuted(AppointmentStatus executed) {
        this.executed = executed;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

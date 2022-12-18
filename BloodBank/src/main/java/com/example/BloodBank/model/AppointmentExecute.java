package com.example.BloodBank.model;

import javax.persistence.*;
import javax.xml.stream.events.Comment;

@Entity
public class AppointmentExecute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appointent_id", referencedColumnName = "id", nullable = true)
    private Appointment appointment;

    private String comment;
    
}

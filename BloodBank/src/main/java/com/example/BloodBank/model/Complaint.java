package com.example.BloodBank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name="complaint")
@Table
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long complaintID;

    @Column(nullable = false)
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "head_admin_id", referencedColumnName = "id", nullable = true)
    private HeadAdmin headAdmin;

    private LocalDate submissionDate ;
}

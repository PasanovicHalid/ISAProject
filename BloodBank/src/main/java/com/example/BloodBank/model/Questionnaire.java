package com.example.BloodBank.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity()
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

//    @NotNull
//    @NotBlank
    private Boolean donated;
    private String donorNumber;
    private LocalDate date;

    public Questionnaire(Long id, Customer customer, Boolean donated) {
        this.id = id;
        this.customer = customer;
        this.donated = donated;
    }

    public Questionnaire(Customer customer, Boolean donated) {
        this.customer = customer;
        this.donated = donated;
    }

    public Questionnaire(Long id, Customer customer, Boolean donated, String donorNumber, LocalDate date) {
        this.id = id;
        this.customer = customer;
        this.donated = donated;
        this.donorNumber = donorNumber;
        this.date = date;
    }

    public Questionnaire() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Boolean getDonated() {
        return donated;
    }

    public void setDonated(Boolean donated) {
        this.donated = donated;
    }

    public String getDonorNumber() {
        return donorNumber;
    }

    public void setDonorNumber(String donorNumber) {
        this.donorNumber = donorNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

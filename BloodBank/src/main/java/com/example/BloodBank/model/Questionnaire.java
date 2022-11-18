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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

//    @NotNull
//    @NotBlank
    private Boolean donated;
    private Boolean denied;
    private Boolean healthy;
    private Boolean eaten;
    private Boolean dangerousJob;
    //FEMALES ONLY
    private Boolean secondState;
    private Boolean menstruating;
    private Boolean pregnant;
    private String donorNumber;
    private LocalDate date;
    public Questionnaire(){}

    public Questionnaire(Long id, Customer customer, Boolean donated,
                         Boolean denied, Boolean healthy, Boolean eaten,
                         Boolean dangerousJob, Boolean secondState,
                         Boolean menstruating, Boolean pregnant,
                         String donorNumber, LocalDate date) {
        this.id = id;
        this.customer = customer;
        this.donated = donated;
        this.denied = denied;
        this.healthy = healthy;
        this.eaten = eaten;
        this.dangerousJob = dangerousJob;
        this.secondState = secondState;
        this.menstruating = menstruating;
        this.pregnant = pregnant;
        this.donorNumber = donorNumber;
        this.date = date;
    }

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

    public Boolean getDenied() {
        return denied;
    }

    public void setDenied(Boolean denied) {
        this.denied = denied;
    }

    public Boolean getHealthy() {
        return healthy;
    }

    public void setHealthy(Boolean healthy) {
        this.healthy = healthy;
    }

    public Boolean getEaten() {
        return eaten;
    }

    public void setEaten(Boolean eaten) {
        this.eaten = eaten;
    }

    public Boolean getDangerousJob() {
        return dangerousJob;
    }

    public void setDangerousJob(Boolean dangerousJob) {
        this.dangerousJob = dangerousJob;
    }

    public Boolean getSecondState() {
        return secondState;
    }

    public void setSecondState(Boolean secondState) {
        this.secondState = secondState;
    }

    public Boolean getMenstruating() {
        return menstruating;
    }

    public void setMenstruating(Boolean menstruating) {
        this.menstruating = menstruating;
    }

    public Boolean getPregnant() {
        return pregnant;
    }

    public void setPregnant(Boolean pregnant) {
        this.pregnant = pregnant;
    }
}

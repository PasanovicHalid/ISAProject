package com.example.BloodBank.dto;

import com.example.BloodBank.model.ComplaintType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreationComplaintDTO {
    @NotNull
    @NotBlank
    private String description;
    @NotNull
    @NotBlank
    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message="Invalid email address!")
    private String emailOfDefendant;
    @NotNull
    private ComplaintType complaintType;
    @NotNull
    @NotBlank
    private String customerUsername;

    public CreationComplaintDTO() {
    }

    public CreationComplaintDTO(String description, String emailOfDefendant, ComplaintType complaintType, String customerUsername) {
        this.description = description;
        this.emailOfDefendant = emailOfDefendant;
        this.complaintType = complaintType;
        this.customerUsername = customerUsername;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmailOfDefendant() {
        return emailOfDefendant;
    }

    public void setEmailOfDefendant(String emailOfDefendant) {
        this.emailOfDefendant = emailOfDefendant;
    }

    public ComplaintType getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(ComplaintType complaintType) {
        this.complaintType = complaintType;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }
}

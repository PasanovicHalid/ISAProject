package com.example.BloodBank.dto.complaintDTOs;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class ComplaintDTO {
    @NotNull
    private Long id;
    @NotNull
    @NotBlank
    private String description;
    @NotNull
    @NotBlank
    private String answer;
    @NotNull
    @NotBlank
    private String defendantName;
    @NotNull
    @NotBlank
    private String complaintType;
    @NotNull
    @NotBlank
    private String customerName;
    @Past
    private LocalDate submissionDate;

    public ComplaintDTO() {
    }

    public ComplaintDTO(Long id, String description, String answer, String defendantName, String complaintType,
                        String customerName, LocalDate submissionDate) {
        this.id = id;
        this.description = description;
        this.answer = answer;
        this.defendantName = defendantName;
        this.complaintType = complaintType;
        this.customerName = customerName;
        this.submissionDate = submissionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDefendantName() {
        return defendantName;
    }

    public void setDefendantName(String defendantName) {
        this.defendantName = defendantName;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }
}

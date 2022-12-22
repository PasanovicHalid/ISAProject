package com.example.BloodBank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionnaireDTO {
    private String customerId;
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
    private String date;
}

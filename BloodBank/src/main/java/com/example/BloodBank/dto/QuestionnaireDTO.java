package com.example.BloodBank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionnaireDTO {
    public long id;
    public long customerId;
    public Boolean donated;
    public Boolean denied;
    public Boolean healthy;
    public Boolean eaten;
    public Boolean dangerousJob;
    public Boolean secondState;
    public Boolean menstruating;
    public Boolean pregnant;
    public String donorNumber;
    public LocalDate fillDate;
}

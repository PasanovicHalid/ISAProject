package com.example.BloodBank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentReserveDTO {

    private long customerId;

    private long appointmentId;
}

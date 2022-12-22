package com.example.BloodBank.dto.appointmentDTOs;

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

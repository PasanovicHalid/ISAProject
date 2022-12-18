package com.example.BloodBank.repository;

import com.example.BloodBank.dto.AppointmentDTO;
import com.example.BloodBank.model.Appointment;
import com.example.BloodBank.model.AppointmentExecute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentExecuteRepository extends JpaRepository<AppointmentExecute,Long> {

}

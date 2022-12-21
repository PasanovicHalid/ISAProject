package com.example.BloodBank.repository;

import com.example.BloodBank.model.Admin;
import com.example.BloodBank.model.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findByConfirmationCode(String confirmationCode);
}

package com.example.BloodBank.repository;

import com.example.BloodBank.model.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("SELECT appointment FROM appointment appointment \n" +
            "WHERE (appointment.takenBy.id = :id) AND :Months6 < appointment.appointmentDate")
    List<Appointment> findAllAppointmentsIn6MonthPeriod(@Param("id") long customerId, @Param("Months6") Date months6);

    @Query("SELECT appointment FROM appointment appointment \n" +
            "WHERE appointment.executed = 3")
    Page<Appointment> findAllAvailable(Pageable page);
}

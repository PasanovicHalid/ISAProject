package com.example.BloodBank.repository;

import com.example.BloodBank.model.Appointment;
import com.example.BloodBank.model.AppointmentStatus;
import com.example.BloodBank.model.Complaint;
import com.example.BloodBank.model.ComplaintStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
//    @Query("select a from appointment a where (a.executed like 'DONE' or a.executed like 'PENDING') and  a.blood_bank_id = 1007")
//    List<Appointment> findDoneAndPendingAppointmentsByBankId(Long bankId);


}

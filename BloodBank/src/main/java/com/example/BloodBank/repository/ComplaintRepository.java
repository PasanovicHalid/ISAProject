package com.example.BloodBank.repository;

import com.example.BloodBank.model.Complaint;
import com.example.BloodBank.model.ComplaintStatus;
import com.example.BloodBank.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  ComplaintRepository extends JpaRepository<Complaint, Long> {
    @Query("select c from complaints c where u.complaint_status like %?1%")
    Page<Complaint> findAllByComplaintStatus(ComplaintStatus status, Pageable pageable);

    @Query("select c from complaints c where u.complaint_status like %?1%")
    List<Complaint> getComplaintsByComplaintStatusAmount(ComplaintStatus status);
}

package com.example.BloodBank.repository;

import com.example.BloodBank.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ComplaintRepository extends JpaRepository<Complaint, Long> {
}

package com.example.BloodBank.repository;

import com.example.BloodBank.model.HeadAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadAdminRepository extends JpaRepository<HeadAdmin, Long> {

}

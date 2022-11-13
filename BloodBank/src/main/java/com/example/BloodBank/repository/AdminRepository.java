package com.example.BloodBank.repository;

import com.example.BloodBank.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
//Qeuery
    Optional<Admin> findByBlodBankId(Long aLong);
}

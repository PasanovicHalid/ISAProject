package com.example.BloodBank.repository;

import com.example.BloodBank.model.NotActivatedUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotActivatedUserRepository extends JpaRepository<NotActivatedUser, Long> {
Optional<NotActivatedUser> findByActivation(String activationCode);
}

package com.example.BloodBank.repository;

import com.example.BloodBank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

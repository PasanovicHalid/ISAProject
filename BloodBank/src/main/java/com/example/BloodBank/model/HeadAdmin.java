package com.example.BloodBank.model;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class HeadAdmin extends User{

    public HeadAdmin(String firstName, String lastName, String username, String password, String email,
                     Gender gender, LocalDate dob, Role role) {
        super(firstName, lastName, username, password, email, gender, dob, role);
    }
}

package com.example.BloodBank.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name="head_admins")
public class HeadAdmin extends User{


    public HeadAdmin(String firstName, String lastName, String username, String password, String email, Gender gender,
                     LocalDate dob, Role role, Address address) {
        super(firstName, lastName, username, password, email, gender, dob, role, address);
    }

    public HeadAdmin() {
    }
}

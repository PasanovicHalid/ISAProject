package com.example.BloodBank.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Customer extends User {
    public Customer(int id, String firstName, String lastName,
                    String username, String password,
                    String email, Gender gender, LocalDate dob,
                    Role role, Address address) {
        super(id, firstName, lastName, username, password,
                email, gender, dob, role, address);
    }

    public Customer(String firstName, String lastName,
                    String username, String password,
                    String email, Gender gender, LocalDate dob,
                    Role role, Address address) {
        super(firstName, lastName, username, password, email,
                gender, dob, role, address);
    }

    public Customer() {
    }
}

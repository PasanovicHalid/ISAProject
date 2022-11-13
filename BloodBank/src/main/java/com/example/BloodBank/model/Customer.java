package com.example.BloodBank.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Customer extends User {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    public Customer(String firstName, String lastName, String username, String password, String email,
                    Gender gender, LocalDate dob, Role role, Address address) {
        super(firstName, lastName, username, password, email, gender, dob, role, address);
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //NOT NEEDED, DELETE LATER
    public Customer(Long id, String firstName, String lastName,
                    String username, String password,
                    String email, Gender gender,
                    LocalDate dob, Role role) {
        super(id, firstName, lastName, username,
                password, email, gender, dob, role);
    }
    
    public Customer() {
    }
}

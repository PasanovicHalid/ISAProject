package com.example.BloodBank.model;

import java.time.LocalDate;

public class Admin extends User{
    private long bloodBankID;

    public Admin(String firstName, String lastName, String username, String password, String email,
                 Gender gender, LocalDate dob, Role role, long bloodBankID) {
        super(firstName, lastName, username, password, email, gender, dob, role);
        this.bloodBankID = bloodBankID;
    }

    public long getBloodBankID() {
        return bloodBankID;
    }

    public void setBloodBankID(long bloodBankID) {
        this.bloodBankID = bloodBankID;
    }
}

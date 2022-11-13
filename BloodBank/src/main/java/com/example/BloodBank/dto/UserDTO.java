package com.example.BloodBank.dto;

import com.example.BloodBank.model.Gender;
import com.example.BloodBank.model.Role;

import java.time.LocalDate;

public class UserDTO {
    public String id;
    public String firstName;
    public String lastName;
    public String username;
    public String password;
    public String email;
    public Gender gender;
    public LocalDate dob;
    public Role role;
}

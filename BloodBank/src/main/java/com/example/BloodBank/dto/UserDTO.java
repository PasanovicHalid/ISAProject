package com.example.BloodBank.dto;

import com.example.BloodBank.model.Address;
import com.example.BloodBank.model.Gender;
import com.example.BloodBank.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class UserDTO {
    @NotNull
    @NotBlank
    @Pattern(regexp="([A-Z][a-z]+)(\\s[A-Z][a-z]+)*", message="Invalid first name input!")
    private String firstName;

    @NotNull
    @NotBlank
    @Pattern(regexp="([A-Z][a-z]+)(\\s[A-Z][a-z]+)*", message="Invalid last name input!")
    private String lastName;

    @NotNull
    @NotBlank
    @Pattern(regexp="([A-Za-z0-9]{3,})", message="Invalid username input!")
    private String username;
    @NotNull
    @NotBlank
    @Pattern(regexp="([A-Za-z0-9]{3,})", message="Invalid password input!")
    private String password;
    @NotBlank
    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message="Invalid email address!" )
    private String email;

    private Gender gender;

    @Past
    private LocalDate dob;
    @NotNull
    @Valid
    private Address address;

    public String id;

    public Role role;

    public UserDTO(String firstName, String lastName, String username, String password, String email, Gender gender, LocalDate dob, Address address, Role role, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.role = role;
        this.id = id;
    }

    public UserDTO(String firstName, String lastName, String username, String password, String email, Gender gender,
                   LocalDate dob, Address address, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.role = role;
    }

    public UserDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

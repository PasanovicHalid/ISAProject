package com.example.BloodBank.dto;

import com.example.BloodBank.model.Address;
import com.example.BloodBank.model.Gender;
import com.example.BloodBank.model.Role;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class ViewUserDTO {
    @NotNull
    @NotBlank
    @Pattern(regexp="([A-Z][a-z]+)(\\s[A-Z][a-z]+)*", message="Invalid first name input!")
    private String firstName;

    @NotNull
    @NotBlank
    @Pattern(regexp="([A-Z][a-z]+)(\\s[A-Z][a-z]+)*", message="Invalid last name input!")
    private String lastName;

    @NotBlank
    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message="Invalid email address!" )
    private String email;

    @NotNull(message = "Gender has to be selected!")
    private Gender gender;

    @Past(message = "Date has to be in the past!")
    private LocalDate dob;
    @NotNull
    @Valid
    private Address address;

    @NotNull
    public Role role;

    public ViewUserDTO() {
    }

    public ViewUserDTO(String firstName, String lastName, String email, Gender gender, LocalDate dob, Address address, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

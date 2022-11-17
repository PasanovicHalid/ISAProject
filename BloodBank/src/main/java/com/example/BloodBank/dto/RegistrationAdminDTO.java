package com.example.BloodBank.dto;

import com.example.BloodBank.model.Address;
import com.example.BloodBank.model.Gender;
import com.example.BloodBank.model.Role;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class RegistrationAdminDTO extends UserDTO{

    @NotNull
    @NotBlank
    private String bankEmail;

    public RegistrationAdminDTO(String firstName, String lastName, String username, String password, String email, Gender gender,
                                LocalDate dob, AddressDTO address, String bankEmail) {
        super(firstName, lastName, username, password, email, gender, dob, address, Role.ADMIN);
        this.bankEmail = bankEmail;
    }

    public RegistrationAdminDTO() {
    }

    public String getBankEmail() {
        return bankEmail;
    }

    public void setBankEmail(String bankEmail) {
        this.bankEmail = bankEmail;
    }
}

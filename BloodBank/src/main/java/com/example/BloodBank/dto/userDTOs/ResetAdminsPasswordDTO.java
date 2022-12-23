package com.example.BloodBank.dto.userDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResetAdminsPasswordDTO {

    @NotNull
    @NotBlank
    @Pattern(regexp="([A-Za-z0-9]{3,})", message="Invalid username input!")
    private String username;
    @NotNull
    @NotBlank
    @Pattern(regexp="([A-Za-z0-9]{3,})", message="Invalid password input!")
    private String oldPassword;
    @NotNull
    @NotBlank
    @Pattern(regexp="([A-Za-z0-9]{3,})", message="Invalid password input!")
    private String newPassword;
}

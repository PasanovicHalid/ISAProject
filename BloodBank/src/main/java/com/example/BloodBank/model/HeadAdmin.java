package com.example.BloodBank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity(name="head_admins")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HeadAdmin extends User{

    @NotNull
    private boolean isPasswordChanged;
}

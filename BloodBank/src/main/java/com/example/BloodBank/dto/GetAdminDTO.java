package com.example.BloodBank.dto;

import javax.validation.constraints.NotNull;

public class GetAdminDTO {
    @NotNull
    private int id;

    public int getId(){ return     id ;}
}

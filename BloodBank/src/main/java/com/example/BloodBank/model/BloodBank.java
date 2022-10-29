package com.example.BloodBank.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table
public class BloodBank extends Blood{

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long bankID;
    private String name;
    private String email;
    //private Address address;
    private String description;
    private double rating;
    private ArrayList<Long> adminIDs;

    public BloodBank(int aplus, int bplus, int ABplus, int oplus, int aminus, int bminus,
                     int ABminus, int ominus, long bankID, String name, String email,
                     String description, double rating, ArrayList<Long> adminIDs) {
        super(aplus, bplus, ABplus, oplus, aminus, bminus, ABminus, ominus);
        this.bankID = bankID;
        this.email = email;
        this.name = name;
        //this.address = address;
        this.description = description;
        this.rating = rating;
        this.adminIDs = adminIDs;
    }

    public BloodBank(int aplus, int bplus, int ABplus, int oplus, int aminus, int bminus,
                     int ABminus, int ominus, String name, String email, String description,
                     double rating, ArrayList<Long> adminIDs) {
        super(aplus, bplus, ABplus, oplus, aminus, bminus, ABminus, ominus);
        this.name = name;
        this.email = email;
       // this.address = address;
        this.description = description;
        this.rating = rating;
        this.adminIDs = adminIDs;
    }

    public long getBankID() {
        return bankID;
    }

    public void setBankID(long bankID) {
        this.bankID = bankID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<Long> getAdminIDs() {
        return adminIDs;
    }

    public void setAdminIDs(ArrayList<Long> adminIDs) {
        this.adminIDs = adminIDs;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

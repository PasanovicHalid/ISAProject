package com.example.BloodBank.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table
public class BloodBank{

    @Id
    @GeneratedValue
    private long bankID;
    private String name;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "blood_id", referencedColumnName = "id")
    private Blood blood;
    private String APIKey;
    private String description;
    private double rating;

    public BloodBank() {
    }

    public BloodBank(long bankID, String name, String email, Address address, Blood blood, String APIKey,
                     String description, double rating) {
        this.bankID = bankID;
        this.name = name;
        this.email = email;
        this.address = address;
        this.blood = blood;
        this.APIKey = APIKey;
        this.description = description;
        this.rating = rating;
    }

    public BloodBank(String name, String email, Address address, Blood blood, String APIKey,
                     String description, double rating) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.blood = blood;
        this.APIKey = APIKey;
        this.description = description;
        this.rating = rating;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Blood getBlood() {
        return blood;
    }

    public void setBlood(Blood blood) {
        this.blood = blood;
    }

    public String getAPIKey() {
        return APIKey;
    }

    public void setAPIKey(String APIKey) {
        this.APIKey = APIKey;
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

//    public ArrayList<Long> getAdminIDs() {
//        return adminIDs;
//    }
//
//    public void setAdminIDs(ArrayList<Long> adminIDs) {
//        this.adminIDs = adminIDs;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

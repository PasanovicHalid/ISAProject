package com.example.BloodBank.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table
public class BloodBank{

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long bankID;
    private String name;
    private String email;
    private Address address;
    private Blood blood;
    private String APIKey;
    private String description;
    private double rating;
    private ArrayList<Long> adminIDs;

    public BloodBank(long bankID, String name, String email, Address address, Blood blood, String APIKey,
                     String description, double rating, ArrayList<Long> adminIDs) {
        this.bankID = bankID;
        this.name = name;
        this.email = email;
        this.address = address;
        this.blood = blood;
        this.APIKey = APIKey;
        this.description = description;
        this.rating = rating;
        this.adminIDs = adminIDs;
    }

    public BloodBank(String name, String email, Address address, Blood blood, String APIKey,
                     String description, double rating, ArrayList<Long> adminIDs) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.blood = blood;
        this.APIKey = APIKey;
        this.description = description;
        this.rating = rating;
        this.adminIDs = adminIDs;
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

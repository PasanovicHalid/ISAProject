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
    private Address address;
    private String description;
    private double rating;
    private ArrayList<Long> adminIDs;

    public BloodBank(double aplus, double bplus, double ABplus, double oplus, double aminus, double bminus,
                     double ABminus, double ominus, long bankID, String name, Address address,
                     String description, double rating, ArrayList<Long> adminIDs) {
        super(aplus, bplus, ABplus, oplus, aminus, bminus, ABminus, ominus);
        this.bankID = bankID;
        this.name = name;
        this.address = address;
        this.description = description;
        this.rating = rating;
        this.adminIDs = adminIDs;
    }

    public BloodBank(double aplus, double bplus, double ABplus, double oplus, double aminus, double bminus,
                     double ABminus, double ominus, String name, Address address, String description,
                     double rating, ArrayList<Long> adminIDs) {
        super(aplus, bplus, ABplus, oplus, aminus, bminus, ABminus, ominus);
        this.name = name;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
}

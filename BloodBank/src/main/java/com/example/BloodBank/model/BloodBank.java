package com.example.BloodBank.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class BloodBank{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bankID;
    @Column(unique=true, nullable = false)
    private String name;
    @Column(unique=true)
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "blood_id", referencedColumnName = "id", nullable = true)
    private Blood blood;
    @Column(unique=true, nullable = true)
    private String APIKey;
    private String description;
    private double rating;
    @OneToMany(mappedBy = "bloodBank", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Admin> admins;
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
      //  this.admins = admins;
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
      //  this.admins = admins;
    }
    public BloodBank(String name, String email, Address address, String description) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.description = description;
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

    public Set<Admin> getAdmins() {
       return admins;
   }

    public void setAdmins(Set<Admin> admins) {
       this.admins = admins;
   }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

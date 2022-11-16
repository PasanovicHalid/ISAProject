package com.example.BloodBank.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity()
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

//    @NotNull
//    @NotBlank
    private Boolean donated;

    public Questionnaire(Long id, User user, Boolean donated) {
        this.id = id;
        this.user = user;
        this.donated = donated;
    }

    public Questionnaire(User user, Boolean donated) {
        this.user = user;
        this.donated = donated;
    }

    public Questionnaire() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getDonated() {
        return donated;
    }

    public void setDonated(Boolean donated) {
        this.donated = donated;
    }
}

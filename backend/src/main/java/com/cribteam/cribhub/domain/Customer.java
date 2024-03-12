package com.cribteam.cribhub.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
public class Customer {
    // Getters
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String userName;

    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name = "crib_id")
    @JsonIgnore
    private Crib crib;

    protected Customer() {
    }

    public Customer(String userName, String email, String password, Crib crib) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.crib = crib;
    }

    public void setCrib(Crib crib) {
        this.crib = crib;
        crib.getCribMembers().add(this);
    }


}
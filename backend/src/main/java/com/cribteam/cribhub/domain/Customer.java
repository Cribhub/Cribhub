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

    //@OneToOne(mappedBy = "crib")
    //@JsonIgnore
    //private Crib crib;

    protected Customer() {
    }

    public Customer(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }


}
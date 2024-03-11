package com.cribteam.cribhub.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerUpdateDTO {
    private String userName;

    private String email;

    private String password;

    public CustomerUpdateDTO(String name, String mail, String test) {
        this.userName = name;
        this.email = mail;
        this.password = test;
    }
}
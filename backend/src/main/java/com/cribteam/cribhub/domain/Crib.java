package com.cribteam.cribhub.domain;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
public class Crib {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cribId;

    private String cribName;

    @OneToMany(mappedBy = "crib")
    private List<Customer> cribMembers;

    protected Crib() {

    }

    public Crib(String cribName, List<Customer> cribMembers){
        this.cribName = cribName;
        this.cribMembers = cribMembers;
    }



}


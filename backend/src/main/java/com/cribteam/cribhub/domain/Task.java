package com.cribteam.cribhub.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Collection;

@Entity
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;

    //@OneToMany(mappedBy = "user")
    //private Collection<Customer> taskMembers;

    private String description;


    protected Task(){
    }

    public Task(Collection<Customer> taskMembers, String description){
        //this.taskMembers = taskMembers;
        this.description = description;
    }

}

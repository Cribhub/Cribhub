package com.cribteam.cribhub.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Getter
@Setter
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ShoppingListId;

    @OneToMany(mappedBy = "user")
    private Collection<Customer> ShoppingListMembers;

    private String shoppingDescription;

    protected ShoppingList(){

    }

    public ShoppingList(String shoppingDescription){
        this.shoppingDescription = shoppingDescription;
    }
}

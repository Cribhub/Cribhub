package com.cribteam.cribhub.repositories;

import com.cribteam.cribhub.domain.ShoppingList;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {


}

package com.cribteam.cribhub.repositories;

import com.cribteam.cribhub.domain.Crib;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CribRepository extends CrudRepository<Crib, Long> {

    Crib findByCribId(long userId);

}

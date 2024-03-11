package com.cribteam.cribhub.repositories;

import com.cribteam.cribhub.DTO.CustomerUpdateDTO;
import com.cribteam.cribhub.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByUserId(CustomerUpdateDTO userId);

    Optional<Customer> findByUserName(String username);

    Optional<Customer> findByEmail(String email);
}

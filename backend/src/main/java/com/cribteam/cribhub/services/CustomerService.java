package com.cribteam.cribhub.services;

import com.cribteam.cribhub.DTO.CustomerUpdateDTO;
import com.cribteam.cribhub.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CustomerService {
    Customer saveCustomer(Customer customer);

    Customer getCustomerById (Long customerId);

    Optional<Customer> getCustomerByEmail (String email);

    // update operation
    Customer updateCustomer(long id, CustomerUpdateDTO customerId);

    Customer deleteCustomer(long customer);
}


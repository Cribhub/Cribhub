package com.cribteam.cribhub.services;

import com.cribteam.cribhub.DTO.CustomerUpdateDTO;
import com.cribteam.cribhub.domain.Customer;
import com.cribteam.cribhub.repositories.CustomerRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    // save operation
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerByEmail(String customerEmail){
        return customerRepository.findByEmail(customerEmail);
    }

    @Override
    public Customer getCustomerById(Long customerId){
        return customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer not found with ID: " + customerId));
    }

    // update operation
    @Override
    public Customer updateCustomer(long id, CustomerUpdateDTO customerId) {
        Customer depDB = customerRepository.findByUserId(customerId);

        return customerRepository.save(depDB);
    }

    @Override
    public Customer deleteCustomer(long customer) {
        return null;
    }


}
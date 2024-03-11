package com.cribteam.cribhub.controller;

import com.cribteam.cribhub.domain.Customer;
import com.cribteam.cribhub.services.CustomerService;
import com.cribteam.cribhub.DTO.CustomerUpdateDTO;


import com.cribteam.cribhub.services.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Validated
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id) {
        Customer customer = customerService.getCustomerById(id);

        return ResponseEntity.ok(customer);
    }


    @DeleteMapping("customer/{id}")
    public ResponseEntity<String> deleteCustomer( @PathVariable long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
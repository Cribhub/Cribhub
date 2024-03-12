package com.cribteam.cribhub.controller;

import com.cribteam.cribhub.DTO.CustomerDTO;
import com.cribteam.cribhub.domain.Crib;
import com.cribteam.cribhub.domain.Customer;
import com.cribteam.cribhub.services.CribService;
import com.cribteam.cribhub.services.CustomerService;


import com.cribteam.cribhub.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CustomerController(CustomerServiceImpl customerService, CribService cribService) {
        this.customerService = customerService;
        this.cribService = cribService;
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody Customer customer) {
        String hashedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(hashedPassword);
        customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerDTO.ConvertToDTO(customer));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable long id) {
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(CustomerDTO.ConvertToDTO(customer));
    }

    @DeleteMapping("customer/{id}")
    public ResponseEntity<String> deleteCustomer( @PathVariable long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    private final CribService cribService;

    @PostMapping("customer/{customerId}/join/{cribId}")
    public ResponseEntity<Crib> joinCrib(@PathVariable Long cribId, @PathVariable Long customerId) {
        Crib crib = cribService.getCribById(cribId);
        if (crib == null) {
            return ResponseEntity.notFound().build();
        }

        Customer customer = customerService.getCustomerById(customerId);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        customer.setCrib(crib);
        crib.getCribMembers().add(customer);
        Crib updatedCrib = cribService.saveCrib(crib);

        return ResponseEntity.ok(updatedCrib);
    }
}
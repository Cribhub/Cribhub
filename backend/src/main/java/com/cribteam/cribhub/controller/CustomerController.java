package com.cribteam.cribhub.controller;

import com.cribteam.cribhub.domain.Customer;
import com.cribteam.cribhub.services.CustomerService;
import com.cribteam.cribhub.DTO.CustomerDTO;
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
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerDTO.ConvertToDTO(customer));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable long id) {
        Customer customer = customerService.getCustomerById(id);

        return ResponseEntity.ok(CustomerDTO.ConvertToDTO(customer));
    }

    @GetMapping("/customer")
    public Optional<Customer> getCustomerByEmail(@RequestParam(name = "email") String customerEmail){
        return customerService.getCustomerByEmail(customerEmail);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("id") long id,  @RequestBody CustomerUpdateDTO updatedCustomer) {
        var result = customerService.updateCustomer(id, updatedCustomer);
        return ResponseEntity.ok(CustomerDTO.ConvertToDTO(result));
    }

    @DeleteMapping("customer/{id}")
    public ResponseEntity<String> deleteCustomer( @PathVariable long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
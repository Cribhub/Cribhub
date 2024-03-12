package com.cribteam.cribhub.DTO;

import lombok.Getter;
import lombok.Setter;
import com.cribteam.cribhub.domain.Customer;

@Setter
@Getter
public class CustomerDTO {
    private Long userId;
    private String userName;
    private String email;
    private Long cribId;

    public static CustomerDTO ConvertToDTO(Customer customer) {
        var dto = new CustomerDTO();
        dto.setUserId(customer.getUserId());
        dto.setEmail(customer.getEmail());
        dto.setUserName(customer.getUserName());
        if (customer.getCrib() != null) {
            dto.cribId = customer.getCrib().getCribId();
        }
        return dto;
    }
}
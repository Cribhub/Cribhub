package com.cribteam.cribhub.DTO;

import com.cribteam.cribhub.domain.Crib;
import lombok.Getter;
import lombok.Setter;
import com.cribteam.cribhub.domain.Customer;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class CribDTO {
    private Long cribId;
    private String cribName;
    private List<Long> cribMemberIds;

    public static CribDTO ConvertToCribDTO (Crib crib) {
        var dto = new CribDTO();
        dto.setCribId(crib.getCribId());
        dto.setCribName(crib.getCribName());
        dto.setCribMemberIds(crib.getCribMembers().stream()
                .map(Customer::getUserId)
                .collect(Collectors.toList()));
        return dto;
    }
}
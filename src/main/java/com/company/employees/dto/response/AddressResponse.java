package com.company.employees.dto.response;

import lombok.Data;

@Data
public class AddressResponse {
    private Long id;
    private String addressLine1;
    private String addressLine2;
    private String country;
    private String city;
}

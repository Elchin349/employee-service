package com.company.employees.dto.request;

import lombok.Data;

@Data
public class AddressRequest {
    private String addressLine1;
    private String addressLine2;
    private String country;
    private String city;
}

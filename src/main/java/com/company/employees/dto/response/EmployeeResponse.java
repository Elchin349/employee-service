package com.company.employees.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class EmployeeResponse implements Serializable{
    private Long id;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String email;
    private String phone;
    private AddressResponse address;
    private JobDetailResponse jobDetail;
}

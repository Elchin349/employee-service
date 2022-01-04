package com.company.employees.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EmployeeRequest {
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String email;
    private String phone;
    private Long departmentId;
    private AddressRequest address;
    private JobDetailRequest jobDetail;
}

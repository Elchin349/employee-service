package com.company.employees.dto.request;

import lombok.Data;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class EmployeeSearchFilter {
    private Integer size;
    private Integer offset;
    private String firstName;
    private String lastName;
    private String finCode;
    private String email;
    private String gender;
    private String phone;
    private String country;
    private String city;
    private LocalDate startBirthDate;
    private LocalDate endBirthDate;
    @Size(min = 250)
    private BigDecimal salaryMin;
    @Size(max = 30000)
    private BigDecimal salaryMax;
    private LocalDate startJobDate;
    private LocalDate endJobDate;
    private boolean isPresent;
}

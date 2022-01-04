package com.company.employees.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class JobDetailRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal salary;
    private boolean isPresent;
}

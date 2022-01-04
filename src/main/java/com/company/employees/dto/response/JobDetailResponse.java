package com.company.employees.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class JobDetailResponse {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal salary;
    private boolean isPresent;
}

package com.company.employees.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SumSalary {
    private BigDecimal salary;

    public SumSalary(BigDecimal salary) {
        this.salary = salary;
    }
}

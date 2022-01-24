package com.company.employees.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class EmployeeCountResponse implements Serializable {
    private String departmentName;
    private long count;
}

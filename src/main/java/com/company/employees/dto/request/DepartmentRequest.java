package com.company.employees.dto.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class DepartmentRequest {
    private String departmentName;
    private LocalDateTime createdAt;
}

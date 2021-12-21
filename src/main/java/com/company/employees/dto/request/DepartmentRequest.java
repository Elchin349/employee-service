package com.company.employees.dto.request;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

public class DepartmentRequest {

    private String departmentName;
    private LocalDateTime createdAt;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

package com.company.employees.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public class DepartmentDetailsResponse {

    private Long id;
    private String departmentName;
    private LocalDateTime createdAt;
    private List<EmployeeResponse> employeeResponseList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<EmployeeResponse> getEmployeeResponseList() {
        return employeeResponseList;
    }

    public void setEmployeeResponseList(List<EmployeeResponse> employeeResponseList) {
        this.employeeResponseList = employeeResponseList;
    }
}

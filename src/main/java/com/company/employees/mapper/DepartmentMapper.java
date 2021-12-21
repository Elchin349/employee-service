package com.company.employees.mapper;

import com.company.employees.dto.request.DepartmentRequest;
import com.company.employees.dto.response.DepartmentResponse;
import com.company.employees.entity.Department;

public class DepartmentMapper {

    public static DepartmentResponse toResponse(Department department) {
        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setId(department.getId());
        departmentResponse.setDepartmentName(department.getDepartmentName());
        departmentResponse.setCreatedAt(department.getCreatedAt());
        return departmentResponse;
    }

    public static Department toEntity(DepartmentRequest request) {
        Department department = new Department();
        department.setDepartmentName(request.getDepartmentName());
        return department;
    }
}

package com.company.employees.mapper;

import com.company.employees.dto.request.DepartmentRequest;
import com.company.employees.dto.response.DepartmentDetailsResponse;
import com.company.employees.dto.response.DepartmentResponse;
import com.company.employees.dto.response.EmployeeResponse;
import com.company.employees.entity.Department;
import com.company.employees.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

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

    public static DepartmentDetailsResponse toResponseDetails(Department department) {
        DepartmentDetailsResponse response = new DepartmentDetailsResponse();
        response.setId(department.getId());
        response.setDepartmentName(department.getDepartmentName());
        response.setCreatedAt(department.getCreatedAt());
        response.setEmployeeResponseList(
                department.getEmployeeList()
                        .stream()
                        .map(DepartmentMapper::toEmployeeResponse)
                        .collect(Collectors.toList())
        );
        return response;
    }

    public static EmployeeResponse toEmployeeResponse(Employee employee) {
        EmployeeResponse response = new EmployeeResponse();
        response.setId(employee.getId());
        response.setFirstName(employee.getFirstName());
        response.setLastName(employee.getLastName());
        response.setAddress(employee.getAddress());
        response.setBirthDate(employee.getBirthDate());
        response.setEmail(employee.getEmail());
        response.setPhone(employee.getPhone());
        return response;
    }
}

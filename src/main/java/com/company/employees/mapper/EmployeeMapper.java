package com.company.employees.mapper;

import com.company.employees.dto.request.EmployeeRequest;
import com.company.employees.dto.response.EmployeeResponse;
import com.company.employees.entity.Employee;

public class EmployeeMapper {

    public static Employee toEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setAddress(request.getAddress());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setBirthDate(request.getBirthDate());
        return employee;
    }

    public static EmployeeResponse toResponse(Employee employee) {
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

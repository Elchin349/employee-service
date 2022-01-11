package com.company.employees.service;

import com.company.employees.dto.common.CommonResponse;
import com.company.employees.dto.request.EmployeeRequest;
import com.company.employees.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    CommonResponse createEmployee(EmployeeRequest request);

    CommonResponse findById(Long id);

    CommonResponse findAll();

    void deleteById(Long id);

    CommonResponse update(Long id, EmployeeRequest employeeRequest);
}

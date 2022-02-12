package com.company.employees.service;

import com.company.employees.dto.EmployeeCountResponse;
import com.company.employees.dto.request.EmployeeRequest;
import com.company.employees.dto.response.EmployeeResponse;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {

    EmployeeResponse createEmployee(EmployeeRequest request);

    EmployeeResponse findById(Long id);

    List<EmployeeResponse> findAll(Integer size, Integer offset, Boolean isActive);

    List<EmployeeResponse> search(Integer size, Integer offset, String firstName, String lastName,
                                  String gender, String finCode, LocalDate start, LocalDate end);

    EmployeeResponse update(Long id, EmployeeRequest employeeRequest);

    List<EmployeeCountResponse> countAllEmployees();

    Long countEmployeeBetweenDate(String start, String end);

    void deleteEmployee(Long id);
}

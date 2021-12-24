package com.company.employees.service;

import com.company.employees.dto.request.DepartmentRequest;
import com.company.employees.dto.response.DepartmentDetailsResponse;
import com.company.employees.dto.response.DepartmentResponse;

import java.util.List;

public interface DepartmentService {

    DepartmentResponse create(DepartmentRequest request);

    DepartmentResponse findById(Long id);

    List<DepartmentResponse> findAll();

    DepartmentResponse update(Long id, DepartmentRequest request);

    DepartmentDetailsResponse getDepartmentGroupByEmployee(Long id);
}

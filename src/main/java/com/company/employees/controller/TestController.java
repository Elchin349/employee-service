package com.company.employees.controller;

import com.company.employees.dto.response.EmployeeResponse;
import com.company.employees.entity.Employee;
import com.company.employees.entity.EmployeeLog;
import com.company.employees.repository.EmployeeLogRepository;
import com.company.employees.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final EmployeeLogRepository employeeLogRepository;
    private final EmployeeService employeeService;

    @GetMapping
    public void create() {

        EmployeeResponse employeeResponse = employeeService.findById(1L);
        EmployeeLog log = new EmployeeLog();
        log.setServiceName("EMPLOYEE_CREATE_SERVICE");
        log.setOperationName("CREATE");
        log.setUsername("elchin123");

    }
}

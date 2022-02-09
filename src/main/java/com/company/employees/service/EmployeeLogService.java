package com.company.employees.service;

import com.company.employees.entity.Employee;

public interface EmployeeLogService {

    void createLog(String operationName, String username,
                   Employee oldRecord, Employee newRecord);

    void createLog(String operationName, String username,Employee newRecord);
}

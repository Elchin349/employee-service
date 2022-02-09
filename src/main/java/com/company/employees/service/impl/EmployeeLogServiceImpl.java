package com.company.employees.service.impl;

import com.company.employees.entity.Employee;
import com.company.employees.entity.EmployeeLog;
import com.company.employees.mapper.EmployeeLogMapper;
import com.company.employees.repository.EmployeeLogRepository;
import com.company.employees.service.EmployeeLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeLogServiceImpl implements EmployeeLogService {

    private final EmployeeLogMapper employeeLogMapper;
    private final EmployeeLogRepository employeeLogRepository;

    @Override
    public void createLog(String operationName, String username,
                          Employee oldRecord, Employee newRecord) {
        EmployeeLog log = employeeLogMapper.toRecord(operationName,username, oldRecord, newRecord);
        employeeLogRepository.save(log);
    }

    @Override
    public void createLog(String operationName, String username, Employee newRecord) {
        EmployeeLog log = employeeLogMapper.toRecord(operationName,username,newRecord);
        employeeLogRepository.save(log);
    }
}

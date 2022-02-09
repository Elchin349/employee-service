package com.company.employees.mapper;

import com.company.employees.entity.Employee;
import com.company.employees.entity.EmployeeLog;
import com.company.employees.entity.LogJsonBRecord;
import org.springframework.stereotype.Component;

@Component
public class EmployeeLogMapper {

    public EmployeeLog toRecord(String operationName, String username,
                                Employee oldRecord, Employee newRecord) {
        EmployeeLog employeeLog = new EmployeeLog();
        employeeLog.setOperationName(operationName);
        employeeLog.setUsername(username);
        employeeLog.setData(createInstance(oldRecord, newRecord));
        return employeeLog;
    }

    public EmployeeLog toRecord(String operationName, String username, Employee newRecord) {
        EmployeeLog employeeLog = new EmployeeLog();
        employeeLog.setOperationName(operationName);
        employeeLog.setUsername(username);
        employeeLog.setData(createInstance(newRecord));
        return employeeLog;
    }

    public LogJsonBRecord createInstance(Employee oldRecord, Employee newRecord) {
        LogJsonBRecord logJsonBRecord = new LogJsonBRecord();
        LogJsonBRecord.OldData oldData = logJsonBRecord.new OldData();
        LogJsonBRecord.NewData newData = logJsonBRecord.new NewData();
        logJsonBRecord.setOldData(mapOldData(oldData, oldRecord));
        logJsonBRecord.setNewData(mapNewData(newData, newRecord));
        return logJsonBRecord;
    }

    public LogJsonBRecord createInstance(Employee newRecord) {
        LogJsonBRecord logJsonBRecord = new LogJsonBRecord();
        LogJsonBRecord.NewData newData = logJsonBRecord.new NewData();
        logJsonBRecord.setNewData(mapNewData(newData, newRecord));
        return logJsonBRecord;
    }

    private LogJsonBRecord.OldData mapOldData(LogJsonBRecord.OldData oldData, Employee oldRecord) {
        oldData.setId(oldRecord.getId());
        oldData.setFirstName(oldRecord.getFirstName());
        oldData.setLastName(oldRecord.getLastName());
        oldData.setBirthDate(oldRecord.getBirthDate());
        oldData.setEmail(oldRecord.getEmail());
        oldData.setFinCode(oldRecord.getFinCode());
        oldData.setPhone(oldRecord.getPhone());
        oldData.setAddressLine1(oldRecord.getAddress().getAddressLine1());
        oldData.setAddressLine2(oldRecord.getAddress().getAddressLine2());
        oldData.setCountry(oldRecord.getAddress().getCountry());
        oldData.setCity(oldRecord.getAddress().getCity());
        oldData.setStartDate(oldRecord.getJobDetail().getStartDate());
        oldData.setEndDate(oldRecord.getJobDetail().getEndDate());
        oldData.setSalary(oldRecord.getJobDetail().getCurrentSalary());
        oldData.setPresent(oldRecord.getJobDetail().isPresent());
        return oldData;
    }

    private LogJsonBRecord.NewData mapNewData(LogJsonBRecord.NewData newData, Employee newRecord) {
        newData.setId(newRecord.getId());
        newData.setFirstName(newRecord.getFirstName());
        newData.setLastName(newRecord.getLastName());
        newData.setBirthDate(newRecord.getBirthDate());
        newData.setEmail(newRecord.getEmail());
        newData.setFinCode(newRecord.getFinCode());
        newData.setPhone(newRecord.getPhone());
        newData.setAddressLine1(newRecord.getAddress().getAddressLine1());
        newData.setAddressLine2(newRecord.getAddress().getAddressLine2());
        newData.setCountry(newRecord.getAddress().getCountry());
        newData.setCity(newRecord.getAddress().getCity());
        newData.setStartDate(newRecord.getJobDetail().getStartDate());
        newData.setEndDate(newRecord.getJobDetail().getEndDate());
        newData.setSalary(newRecord.getJobDetail().getCurrentSalary());
        newData.setPresent(newRecord.getJobDetail().isPresent());
        return newData;
    }
}

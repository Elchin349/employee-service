package com.company.employees.constants;

public class SqlConstants {

    String COUNT_ALL_EMPLOYEES_GROUP_BY_DEPARTMENT = "select new com.company.employees.dto.EmployeeCount(e.department.departmentName,count(e)) from Employee e group by e.department.departmentName";
}

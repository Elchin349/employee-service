package com.company.employees.exception;

public enum BusinessExceptionEnum {
    EMPLOYEE_BY_ID_NOT_FOUND("Employee by id: %s not found"),
    DEPARTMENT_BY_ID_NOT_FOUND("Department by id: %s not found");

    BusinessExceptionEnum(String msg) {
        this.msg = msg;
    }

    private String msg;

    public String getMsg() {
        return msg;
    }
}

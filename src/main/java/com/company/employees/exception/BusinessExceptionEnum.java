package com.company.employees.exception;

public enum BusinessExceptionEnum {
    EMPLOYEE_BY_ID_NOT_FOUND("Employee by id: %s not found",
            "404",
            "the employee not found in our database"),
    DEPARTMENT_BY_ID_NOT_FOUND("Department by id: %s not found",
            "404",
            "the department not found in our database");

    BusinessExceptionEnum(String msg, String code, String description) {
        this.msg = msg;
        this.code = code;
        this.description = description;
    }

    private String msg;
    private String code;
    private String description;

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}

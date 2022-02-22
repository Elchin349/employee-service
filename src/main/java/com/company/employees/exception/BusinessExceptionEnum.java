package com.company.employees.exception;

public enum BusinessExceptionEnum {
    EMPLOYEE_BY_ID_NOT_FOUND("Employee by id: %s not found",
            "404",
            "the employee not found in our database"),
    DEPARTMENT_BY_ID_NOT_FOUND("Department by id: %s not found",
            "404",
            "the department not found in our database"),
    EMPLOYEE_IS_NOT_ACTIVE_FOR_UPDATE("Employee is not active for update",
            "500",
            "Employee is not active for update"),
    UPLOAD_IMAGE_ERROR("Error occured while upload image",
            "500",
            "Error occurred while upload image"),
    DATE_TIME_FORMAT_ERROR("Date Time pattern is not valid",
            "404",
            "Date Time pattern (yyyy-MM-dd hh:mm:ss) is not valid"),
    DATE_FORMAT_ERROR("Date pattern(yyyy-MM-dd) is not valid",
            "404",
            "Date pattern(yyyy-MM-dd) is not valid"),
    ;

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

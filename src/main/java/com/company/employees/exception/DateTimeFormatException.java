package com.company.employees.exception;

public class DateTimeFormatException extends BaseException{

    public DateTimeFormatException(String code, String msg, String description) {
        super(code, msg, description);
    }

    public DateTimeFormatException(BusinessExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg(), exceptionEnum.getCode(), exceptionEnum.getDescription());
    }
}

package com.company.employees.exception;

public class InternalException extends BaseException {

    public InternalException(BusinessExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg(), exceptionEnum.getCode(), exceptionEnum.getDescription());
    }

    public InternalException(BusinessExceptionEnum exceptionEnum, Object object) {
        super(exceptionEnum.getCode(), String.format(exceptionEnum.getMsg(), object), exceptionEnum.getDescription());
    }
}

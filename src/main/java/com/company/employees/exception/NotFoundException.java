package com.company.employees.exception;

public class NotFoundException extends BaseException {

    public NotFoundException(BusinessExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg(), exceptionEnum.getCode(), exceptionEnum.getDescription());
    }

    public NotFoundException(BusinessExceptionEnum exceptionEnum, Object object) {
        super(exceptionEnum.getCode(),String.format(exceptionEnum.getMsg(), object), exceptionEnum.getDescription());
    }
}

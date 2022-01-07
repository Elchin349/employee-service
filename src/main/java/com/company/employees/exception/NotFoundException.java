package com.company.employees.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(BusinessExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
    }

    public NotFoundException(BusinessExceptionEnum exceptionEnum, Object object) {
        super(String.format(exceptionEnum.getMsg(), object));
    }
}

package com.company.employees.exception;

public class BaseException extends RuntimeException {
    private String code;
    private String msg;
    private String description;

    public BaseException(String code, String msg, String description) {
        this.code = code;
        this.msg = msg;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getDescription() {
        return description;
    }


}

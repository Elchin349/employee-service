package com.company.employees.controller;


import com.company.employees.dto.common.CommonMessage;
import com.company.employees.dto.common.CommonResponse;
import com.company.employees.exception.BaseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(BaseException.class)
    protected ResponseEntity<CommonResponse> handleConflict(BaseException ex, WebRequest request) {
        CommonResponse apiMessage = new CommonResponse();
        apiMessage.setStatus("error");
        CommonMessage message = new CommonMessage();
        message.setMessage(ex.getMsg());
        message.setCode(ex.getCode());
        message.setDescription(ex.getDescription());
        apiMessage.setErrorMessage(message);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(apiMessage);
    }
}

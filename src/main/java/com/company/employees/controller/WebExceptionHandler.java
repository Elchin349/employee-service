package com.company.employees.controller;

import com.company.employees.container.api.ApiBuilder;
import com.company.employees.container.api.ApiMessage;
import com.company.employees.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class WebExceptionHandler implements ApiBuilder {

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<ApiMessage> handleConflict(RuntimeException ex, WebRequest request) {
        ApiMessage apiMessage = generateApiMessage(generateApiInfo(ex));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(apiMessage);
    }

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ApiMessage> handleConflict(NotFoundException ex, WebRequest request) {
        ApiMessage apiMessage = generateApiMessage(generateApiInfo(ex));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(apiMessage);
    }
}

package com.company.employees.dto.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommonMessage implements Serializable {
    private String code;
    private String message;
    private String description;
}

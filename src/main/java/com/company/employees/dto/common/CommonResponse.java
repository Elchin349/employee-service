package com.company.employees.dto.common;

import lombok.Data;

import javax.persistence.PrePersist;
import java.io.Serializable;
import java.util.UUID;

@Data
public class CommonResponse implements Serializable {
    private Long time = System.currentTimeMillis();
    private String status;
    private Object item;
    private CommonMessage errorMessage;
}

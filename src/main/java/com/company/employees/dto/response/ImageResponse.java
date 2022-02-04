package com.company.employees.dto.response;

import lombok.Data;

@Data
public class ImageResponse {
    private Long id;
    private String name;
    private String type;
    private byte[] data;
}

package com.company.employees.mapper;

import com.company.employees.dto.response.ImageResponse;
import com.company.employees.entity.Image;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {

    public ImageResponse toResponse(Image image) {
        ImageResponse response = new ImageResponse();
        response.setId(image.getId());
        response.setData(image.getData());
        response.setName(image.getName());
        response.setType(image.getType());
        return response;
    }
}

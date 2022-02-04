package com.company.employees.controller;

import com.company.employees.container.api.ApiBuilder;
import com.company.employees.container.api.SingleMessage;
import com.company.employees.service.impl.ImageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageController implements ApiBuilder {

    private final ImageServiceImpl imageServiceImpl;

    @PostMapping
    public ResponseEntity<SingleMessage<String>> uploadImage(
            MultipartFile file,
            @RequestParam(name = "employeeId") Long employeeId) {
        return ResponseEntity.ok(generateSingleMessage(imageServiceImpl.uploadImage(file, employeeId)));
    }
}

package com.company.employees.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    String uploadImage(MultipartFile file, Long employeeId);
}

package com.company.employees.service.impl;

import com.company.employees.constants.CommonConstant;
import com.company.employees.entity.Employee;
import com.company.employees.entity.Image;
import com.company.employees.exception.BusinessExceptionEnum;
import com.company.employees.exception.InternalException;
import com.company.employees.exception.NotFoundException;
import com.company.employees.repository.EmployeeRepository;
import com.company.employees.repository.ImageRepository;
import com.company.employees.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static com.company.employees.constants.CommonConstant.SUCCESS;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public String uploadImage(MultipartFile file, Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isPresent()) {
            try {
                Image image = new Image();
                image.setName(file.getName());
                image.setType(file.getContentType());
                image.setData(file.getBytes());
                image.setEmployee(employee.get());
                imageRepository.save(image);
                return SUCCESS;
            } catch (Exception e) {
                throw new InternalException(BusinessExceptionEnum.UPLOAD_IMAGE_ERROR);
            }
        }
        throw new NotFoundException(BusinessExceptionEnum.EMPLOYEE_BY_ID_NOT_FOUND, employee);
    }
}

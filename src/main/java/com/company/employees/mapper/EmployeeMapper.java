package com.company.employees.mapper;

import com.company.employees.dto.request.EmployeeRequest;
import com.company.employees.dto.response.EmployeeResponse;
import com.company.employees.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {

    private final AddressMapper addressMapper;
    private final JobDetailMapper jobDetailMapper;
    private final ImageMapper imageMapper;

    public Employee toEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setFinCode(request.getFinCode());
        employee.setPhone(request.getPhone());
        employee.setBirthDate(request.getBirthDate());
        employee.setAddress(addressMapper.toEntity(request.getAddress(), employee));
        employee.setAddress(addressMapper.toEntity(request.getAddress()));
        employee.setJobDetail(jobDetailMapper.toEntity(request.getJobDetail(), employee));
        return employee;
    }

    public EmployeeResponse toResponse(Employee employee) {
        EmployeeResponse response = new EmployeeResponse();
        response.setId(employee.getId());
        response.setFirstName(employee.getFirstName());
        response.setLastName(employee.getLastName());
        response.setBirthDate(employee.getBirthDate());
        employee.setFinCode(employee.getFinCode());
        response.setEmail(employee.getEmail());
        response.setPhone(employee.getPhone());
        response.setAddress(addressMapper.toResponse(employee.getAddress()));
        response.setJobDetail(jobDetailMapper.toResponse(employee.getJobDetail()));
        if (!ObjectUtils.isEmpty(employee.getImage()))
            response.setImage(imageMapper.toResponse(employee.getImage()));
        return response;
    }
}

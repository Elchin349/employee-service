package com.company.employees.mapper;

import com.company.employees.dto.request.EmployeeRequest;
import com.company.employees.dto.response.EmployeeResponse;
import com.company.employees.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {

    private final AddressMapper addressMapper;

    public Employee toEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setBirthDate(request.getBirthDate());
        employee.setAddress(addressMapper.toEntity(request.getAddress(),employee));
        //employee.setAddress(addressMapper.toEntity(request.getAddress()));
        return employee;
    }

    public EmployeeResponse toResponse(Employee employee) {
        EmployeeResponse response = new EmployeeResponse();
        response.setId(employee.getId());
        response.setFirstName(employee.getFirstName());
        response.setLastName(employee.getLastName());
        response.setBirthDate(employee.getBirthDate());
        response.setEmail(employee.getEmail());
        response.setPhone(employee.getPhone());
        response.setAddress(addressMapper.toResponse(employee.getAddress()));
        return response;
    }
}

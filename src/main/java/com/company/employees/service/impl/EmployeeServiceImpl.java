package com.company.employees.service.impl;

import com.company.employees.dto.request.EmployeeRequest;
import com.company.employees.dto.response.EmployeeResponse;
import com.company.employees.entity.Employee;
import com.company.employees.mapper.EmployeeMapper;
import com.company.employees.repository.EmployeeRepository;
import com.company.employees.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request) {
        Employee employee = EmployeeMapper.toEmployee(request);
        employee = employeeRepository.save(employee);
        return EmployeeMapper.toResponse(employee);
    }

    @Override
    public EmployeeResponse findById(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return EmployeeMapper.toResponse(employee.get());
        }
        throw new RuntimeException("yoxdu");
    }

    @Override
    public List<EmployeeResponse> findAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeResponse> responses = new ArrayList<>();
        for (Employee e : employeeList) {
            responses.add(EmployeeMapper.toResponse(e));
        }
        return responses;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        employee.ifPresent(employeeRepository::delete);
    }

    @Override
    public EmployeeResponse update(Long id, EmployeeRequest employeeRequest) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            Employee employee1 = EmployeeMapper.toEmployee(employeeRequest);
            employee1.setId(id);
            return EmployeeMapper.toResponse(employeeRepository.save(employee1));
        }
        return null;
    }

}

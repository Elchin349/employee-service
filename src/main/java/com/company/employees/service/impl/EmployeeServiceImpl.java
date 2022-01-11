package com.company.employees.service.impl;

import com.company.employees.dto.request.EmployeeRequest;
import com.company.employees.dto.response.EmployeeResponse;
import com.company.employees.entity.Department;
import com.company.employees.entity.Employee;
import com.company.employees.exception.BusinessExceptionEnum;
import com.company.employees.exception.NotFoundException;
import com.company.employees.mapper.EmployeeMapper;
import com.company.employees.repository.DepartmentRepository;
import com.company.employees.repository.EmployeeRepository;
import com.company.employees.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request) {

        Employee employee = employeeMapper.toEmployee(request);
        Optional<Department> department = departmentRepository.findById(request.getDepartmentId());
        if (department.isPresent()) {
            employee.setDepartment(department.get());
            employee = employeeRepository.save(employee);
            return employeeMapper.toResponse(employee);
        }
        throw new NotFoundException(BusinessExceptionEnum.DEPARTMENT_BY_ID_NOT_FOUND, request.getDepartmentId());
    }

    @Override
    public EmployeeResponse findById(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employeeMapper.toResponse(employee.get());
        }
        throw new NotFoundException(BusinessExceptionEnum.EMPLOYEE_BY_ID_NOT_FOUND, id);
    }

    @Override
    public List<EmployeeResponse> findAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeResponse> responses = new ArrayList<>();
        for (Employee e : employeeList) {
            responses.add(employeeMapper.toResponse(e));
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
            Employee employee1 = employeeMapper.toEmployee(employeeRequest);
            employee1.setId(id);
            return employeeMapper.toResponse(employeeRepository.save(employee1));
        }
        return null;
    }

}

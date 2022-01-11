package com.company.employees.service.impl;

import com.company.employees.dto.common.CommonResponse;
import com.company.employees.dto.request.EmployeeRequest;
import com.company.employees.dto.response.EmployeeResponse;
import com.company.employees.entity.Department;
import com.company.employees.entity.Employee;
import com.company.employees.entity.SumSalary;
import com.company.employees.exception.BusinessExceptionEnum;
import com.company.employees.exception.NotFoundException;
import com.company.employees.mapper.EmployeeMapper;
import com.company.employees.repository.DepartmentRepository;
import com.company.employees.repository.EmployeeRepository;
import com.company.employees.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.PostConstruct;
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
    public CommonResponse createEmployee(EmployeeRequest request) {

        CommonResponse commonResponse = new CommonResponse();
        Employee employee = employeeMapper.toEmployee(request);
        Optional<Department> department = departmentRepository.findById(request.getDepartmentId());
        if (department.isPresent()) {
            employee.setDepartment(department.get());
            employee = employeeRepository.save(employee);
            commonResponse.setItem(employeeMapper.toResponse(employee));
            commonResponse.setStatus("Success");
            return commonResponse;
        }
        throw new NotFoundException(BusinessExceptionEnum.DEPARTMENT_BY_ID_NOT_FOUND, request.getDepartmentId());
    }

    @Override
    public CommonResponse findById(@PathVariable Long id) {
        CommonResponse commonResponse = new CommonResponse();
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            commonResponse.setStatus("success");
            commonResponse.setItem(employeeMapper.toResponse(employee.get()));
            return commonResponse;
        }
        throw new NotFoundException(BusinessExceptionEnum.EMPLOYEE_BY_ID_NOT_FOUND, id);
    }

    @Override
    public CommonResponse findAll() {
        CommonResponse commonResponse = new CommonResponse();
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeResponse> responses = new ArrayList<>();
        for (Employee e : employeeList) {
            responses.add(employeeMapper.toResponse(e));
        }
        commonResponse.setStatus("success");
        commonResponse.setItem(responses);
        return commonResponse;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        employee.ifPresent(employeeRepository::delete);
    }

    @Override
    public CommonResponse update(Long id, EmployeeRequest employeeRequest) {
        CommonResponse commonResponse = new CommonResponse();
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            Employee employee1 = employeeMapper.toEmployee(employeeRequest);
            employee1.setId(id);

            commonResponse.setStatus("success");
            commonResponse.setItem(employeeMapper.toResponse(employeeRepository.save(employee1)));
            return commonResponse;
        }
        return null;
    }

}

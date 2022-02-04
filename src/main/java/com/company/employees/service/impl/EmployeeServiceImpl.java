package com.company.employees.service.impl;

import com.company.employees.dto.EmployeeCountResponse;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeMapper employeeMapper;

    @Transactional
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

    @Transactional
    @Override
    public EmployeeResponse findById(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employeeMapper.toResponse(employee.get());
        }
        throw new NotFoundException(BusinessExceptionEnum.EMPLOYEE_BY_ID_NOT_FOUND, id);
    }

    @Transactional
    @Override
    public List<EmployeeResponse> findAll(Integer size, Integer offset, Boolean isActive) {
        List<Employee> employees;
        if (!isActive) {
            employees = findAllActiveEmployees(size, offset);
        } else {
            employees = findAllEmployees(size, offset);
        }
        return employees
                .stream()
                .map(employeeMapper::toResponse)
                .collect(Collectors.toList());
    }

    private List<Employee> findAllActiveEmployees(Integer size, Integer offset) {
        return employeeRepository.getEmployeesByActiveIsTrue(PageRequest.of(offset, size));
    }

    private List<Employee> findAllEmployees(Integer size, Integer offset) {
        return employeeRepository.findAll(PageRequest.of(offset, size)).getContent();
    }

    @Transactional
    @Override
    public EmployeeResponse update(Long id, EmployeeRequest employeeRequest) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            if (employee.get().getActive()) {
                Employee employee1 = employeeMapper.toEmployee(employeeRequest);
                employee1.setId(id);
                return employeeMapper.toResponse(employeeRepository.save(employee1));
            }
            throw new NotFoundException(BusinessExceptionEnum.EMPLOYEE_IS_NOT_ACTIVE_FOR_UPDATE);
        }
        throw new NotFoundException(BusinessExceptionEnum.EMPLOYEE_BY_ID_NOT_FOUND, id);
    }

    @Override
    public List<EmployeeCountResponse> countAllEmployees() {
        return employeeRepository.countAllEmployeesGroupByDepartmentV2();
    }

    @Override
    public Long countEmployeeBetweenDate(String start, String end) {
        LocalDateTime startDate = LocalDateTime.parse(start, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime endDate = LocalDateTime.parse(end, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return employeeRepository.countByCreatedAtBetween(startDate, endDate);
    }

    @Override
    public void deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employee.get().setActive(Boolean.FALSE);
            employeeRepository.save(employee.get());
        } else {
            throw new NotFoundException(BusinessExceptionEnum.EMPLOYEE_BY_ID_NOT_FOUND, id);
        }
    }
}

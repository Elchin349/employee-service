package com.company.employees.service.impl;

import com.company.employees.dto.request.DepartmentRequest;
import com.company.employees.dto.response.DepartmentDetailsResponse;
import com.company.employees.dto.response.DepartmentResponse;
import com.company.employees.entity.Department;
import com.company.employees.entity.Employee;
import com.company.employees.mapper.DepartmentMapper;
import com.company.employees.repository.DepartmentRepository;
import com.company.employees.repository.EmployeeRepository;
import com.company.employees.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public DepartmentResponse create(DepartmentRequest request) {
        return DepartmentMapper.toResponse(departmentRepository.save(DepartmentMapper.toEntity(request)));
    }

    @Override
    public DepartmentResponse findById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
//        if(department.isPresent()) {
//            return DepartmentMapper.toResponse(department.get());
//        }
//        return null;
        return department.map(DepartmentMapper::toResponse).orElse(null);
    }

    @Override
    public List<DepartmentResponse> findAll() {
        List<DepartmentResponse> departmentResponses = new ArrayList<>();
        List<Department> departments = departmentRepository.findAll();
//        for(Department d : departments) {
//            departmentResponses.add(DepartmentMapper.toResponse(d));
//        }
//        return departmentResponses;
//        return departments.stream().map(department -> DepartmentMapper.toResponse(department)).collect(Collectors.toList());
        return departments.stream()
                .map(DepartmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentResponse update(Long id, DepartmentRequest request) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            Department department1 = DepartmentMapper.toEntity(request);
            department1.setId(id);
            return DepartmentMapper.toResponse(departmentRepository.save(department1));
        }
        return null;
    }

    @Override
    @Transactional
    public DepartmentDetailsResponse getDepartmentGroupByEmployee(Long id) {
        Department department = departmentRepository.findById(id).get();
        return DepartmentMapper.toResponseDetails(department);
    }
}

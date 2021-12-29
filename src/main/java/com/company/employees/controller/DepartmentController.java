package com.company.employees.controller;

import com.company.employees.dto.request.DepartmentRequest;
import com.company.employees.dto.response.DepartmentDetailsResponse;
import com.company.employees.dto.response.DepartmentResponse;
import com.company.employees.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAll() {
        return ResponseEntity.ok(departmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.findById(id));
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<DepartmentDetailsResponse> getDetailsById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getDepartmentGroupByEmployee(id));
    }

    @GetMapping("/details")
    public ResponseEntity<List<DepartmentDetailsResponse>> getDetails() {
        List<DepartmentDetailsResponse> departmentDetailsResponses = departmentService.getAllDepartmentGroupByEmployee();
        return ResponseEntity.ok(departmentDetailsResponses);
    }

    @PostMapping
    public ResponseEntity<DepartmentResponse> create(@RequestBody DepartmentRequest departmentRequest) {
        return ResponseEntity.ok(departmentService.create(departmentRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponse> update(@PathVariable Long id,
                                                     @RequestBody DepartmentRequest departmentRequest) {
        return ResponseEntity.ok(departmentService.update(id, departmentRequest));
    }
}

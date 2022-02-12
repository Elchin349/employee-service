package com.company.employees.controller;

import com.company.employees.container.api.ApiBuilder;
import com.company.employees.container.api.CollectionMessage;
import com.company.employees.container.api.SingleMessage;
import com.company.employees.dto.EmployeeCountResponse;
import com.company.employees.dto.request.EmployeeRequest;
import com.company.employees.dto.response.EmployeeResponse;
import com.company.employees.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/employee")
public class EmployeeController implements ApiBuilder {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> create(@RequestBody EmployeeRequest request) {
        EmployeeResponse response = employeeService.createEmployee(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SingleMessage<EmployeeResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(generateSingleMessage(employeeService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<CollectionMessage<EmployeeResponse>> getAll(@RequestParam(required = false, defaultValue = "20") Integer size,
                                                                      @RequestParam(required = false, defaultValue = "0") Integer offset,
                                                                      @RequestParam(required = false, defaultValue = "false") Boolean isActive) {
        return ResponseEntity.ok(generateCollectionMessage(employeeService.findAll(size, offset, isActive)));
    }

    @GetMapping("/search")
    public ResponseEntity<CollectionMessage<EmployeeResponse>> search(@RequestParam(required = false, defaultValue = "20") Integer size,
                                                                      @RequestParam(required = false, defaultValue = "0") Integer offset,
                                                                      @RequestParam(required = false) String firstName,
                                                                      @RequestParam(required = false) String lastName,
                                                                      @RequestParam(required = false) String gender,
                                                                      @RequestParam(required = false) String finCode,
                                                                      @RequestParam(required = false) String start,
                                                                      @RequestParam(required = false) String end
    ) {
        return ResponseEntity.ok(generateCollectionMessage(employeeService.search(size, offset, firstName,
                lastName, gender, finCode, LocalDate.parse(start), LocalDate.parse(end))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> update(@PathVariable Long id, @RequestBody EmployeeRequest request) {
        EmployeeResponse response = employeeService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/count-employees")
    public ResponseEntity<CollectionMessage<EmployeeCountResponse>> countAllEmployees() {
        return ResponseEntity.ok(generateCollectionMessage(employeeService.countAllEmployees()));
    }
}

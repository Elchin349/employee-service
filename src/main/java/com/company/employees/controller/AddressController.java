package com.company.employees.controller;

import com.company.employees.dto.request.AddressRequest;
import com.company.employees.dto.response.AddressResponse;
import com.company.employees.service.AddressService;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressResponse> create(@RequestBody AddressRequest request){
        return ResponseEntity.ok(addressService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(addressService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<AddressResponse>> getAll(){
        return ResponseEntity.ok(addressService.getAll());
    }


}

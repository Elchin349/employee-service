package com.company.employees.service;

import com.company.employees.dto.request.AddressRequest;
import com.company.employees.dto.response.AddressResponse;

import java.util.List;

public interface AddressService {

    AddressResponse create(AddressRequest request);

    AddressResponse getById(Long id);

    List<AddressResponse> getAll();

    AddressResponse update(Long id, AddressRequest request);

    void delete(Long id);
}

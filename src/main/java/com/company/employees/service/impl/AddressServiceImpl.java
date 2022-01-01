package com.company.employees.service.impl;

import com.company.employees.dto.request.AddressRequest;
import com.company.employees.dto.response.AddressResponse;
import com.company.employees.entity.Address;
import com.company.employees.mapper.AddressMapper;
import com.company.employees.repository.AddressRepository;
import com.company.employees.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public AddressResponse create(AddressRequest request) {
        return addressMapper.toResponse(
                addressRepository.save(
                        addressMapper.toEntity(request))
        );
    }

    @Override
    public AddressResponse getById(Long id) {
        return addressRepository.findById(id)
                .map(addressMapper::toResponse)
                .orElse(null);
    }

    @Override
    public List<AddressResponse> getAll() {
        return addressRepository.findAll().stream()
                .map(addressMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AddressResponse update(Long id, AddressRequest request) {
        if (addressRepository.findById(id).isPresent()) {
            Address address = addressMapper.toEntity(request);
            address.setId(id);
            return addressMapper.toResponse(addressRepository.save(address));
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}

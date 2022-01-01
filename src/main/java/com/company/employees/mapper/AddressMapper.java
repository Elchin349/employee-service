package com.company.employees.mapper;

import com.company.employees.dto.request.AddressRequest;
import com.company.employees.dto.response.AddressResponse;
import com.company.employees.entity.Address;
import com.company.employees.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressResponse toResponse(Address address) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(address.getId());
        addressResponse.setAddressLine1(address.getAddressLine1());
        addressResponse.setAddressLine2(address.getAddressLine2());
        addressResponse.setCountry(address.getCountry());
        addressResponse.setCity(address.getCity());
        return addressResponse;
    }

    public Address toEntity(AddressRequest request) {
        Address address = new Address();
        address.setAddressLine1(request.getAddressLine1());
        address.setAddressLine2(request.getAddressLine2());
        address.setCity(request.getCity());
        address.setCountry(request.getCountry());
        return address;
    }

    public Address toEntity(AddressRequest request, Employee employee) {
        Address address = new Address();
        address.setAddressLine1(request.getAddressLine1());
        address.setAddressLine2(request.getAddressLine2());
        address.setCity(request.getCity());
        address.setCountry(request.getCountry());
        address.setEmployee(employee);
        return address;
    }
}

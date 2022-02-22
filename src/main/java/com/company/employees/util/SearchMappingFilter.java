package com.company.employees.util;


import com.company.employees.dto.request.EmployeeSearchFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;

import static com.company.employees.util.DateConverterUtil.toLocalDate;

@Component
public class SearchMappingFilter {

    public  EmployeeSearchFilter setMapFilter(
            Integer size,
            Integer offset,
            String firstName,
            String lastName,
            String gender,
            String finCode,
            String email,
            String phone,
            String country,
            String city,
            String startBirthDate,
            String endBirthDate,
            BigDecimal salaryMin,
            BigDecimal salaryMax,
            String startJobDate,
            String endJobDate,
            Boolean isPresent
    ) {
        EmployeeSearchFilter filter = new EmployeeSearchFilter();
        filter.setSize(size);
        filter.setOffset(offset);
        if (!ObjectUtils.isEmpty(firstName))
            filter.setFirstName(firstName);
        if (!ObjectUtils.isEmpty(lastName))
            filter.setLastName(lastName);
        if (!ObjectUtils.isEmpty(gender))
            filter.setGender(gender);
        if (!ObjectUtils.isEmpty(finCode))
            filter.setFinCode(finCode);
        if (!ObjectUtils.isEmpty(email))
            filter.setEmail(email);
        if (!ObjectUtils.isEmpty(phone))
            filter.setPhone(phone);
        if (!ObjectUtils.isEmpty(country))
            filter.setCountry(country);
        if (!ObjectUtils.isEmpty(city))
            filter.setCity(city);
        if (!ObjectUtils.isEmpty(startBirthDate))
            filter.setStartBirthDate(toLocalDate(startBirthDate));
        if (!ObjectUtils.isEmpty(endBirthDate))
            filter.setEndBirthDate(toLocalDate(endBirthDate));
        if (!ObjectUtils.isEmpty(salaryMax))
            filter.setSalaryMax(salaryMax);
        if (!ObjectUtils.isEmpty(salaryMin))
            filter.setSalaryMin(salaryMin);
        if (!ObjectUtils.isEmpty(startJobDate))
            filter.setStartJobDate(toLocalDate(startJobDate));
        if (!ObjectUtils.isEmpty(endJobDate))
            filter.setEndJobDate(toLocalDate(endJobDate));
        if (!ObjectUtils.isEmpty(isPresent))
            filter.setPresent(isPresent);
        return filter;
    }
}

package com.company.employees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeesApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeesApplication.class, args);
    }

    /**
     *    Address table
     *    country
     *    city
     *    district
     *    street
     *    one to one
     *
     *
     *
     *    EmployeeDetails
     *    startDate
     *    endDate
     *    salary
     *    departmentId
     *
     */
}

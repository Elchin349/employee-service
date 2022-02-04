package com.company.employees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeesApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeesApplication.class, args);

        /**
         *
         * Auth-service
         *
         * User
         * id
         * username
         * password
         * createAt
         * role class one to one
         *
         * Role
         * id
         * name
         * permission one to many
         *
         * Permission;
         * id
         * name;
         *
         */
    }
}

package com.company.employees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeesApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeesApplication.class, args);

        /**
         * job table deyisecek
         * job_details
         * {
         * id ,
         * employee_id,
         * start date ,
         * end date,
         * active,
         * department_id,
         * current_salary,
         * position_title
         * new_salary
         * }
         *
         *
         *
         * iscilerin departamentlere gore qruplasdirmaq datani usere gostermek
         * iscilerin dapertamente gore qruplasdirib toplam maasi gostermek
         * iscilerin dapertamente gore qruplasdirib toplam isci sayisini gostermek
         *
         *
         */
    }

}

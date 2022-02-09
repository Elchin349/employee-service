package com.company.employees.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class LogJsonBRecord implements Serializable {
    private final static long serialVersionUID = -2870722818466526833L;

    private NewData newData;
    private OldData oldData;

    @Getter
    @Setter
    public class NewData {
        private Long id;
        private String firstName;
        private String lastName;
        private LocalDate birthDate;
        private String email;
        private String finCode;
        private String phone;
        private LocalDateTime createdAt;
        private LocalDate startDate;
        private LocalDate endDate;
        private BigDecimal salary;
        private boolean isPresent;
        private String addressLine1;
        private String addressLine2;
        private String country;
        private String city;
    }

    @Setter
    @Getter
    public class OldData {
        private Long id;
        private String firstName;
        private String lastName;
        private LocalDate birthDate;
        private String email;
        private String finCode;
        private String phone;
        private LocalDateTime createdAt;
        private LocalDate startDate;
        private LocalDate endDate;
        private BigDecimal salary;
        private boolean isPresent;
        private String addressLine1;
        private String addressLine2;
        private String country;
        private String city;
    }
}

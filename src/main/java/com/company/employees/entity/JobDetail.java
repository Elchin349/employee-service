package com.company.employees.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "job_details")
@Setter
@Getter
public class JobDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "is_present")
    private boolean isPresent;
    @Column(name = "current_salary")
    private BigDecimal currentSalary;
    @Column(name = "last_salary")
    private BigDecimal lastSalary;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @PrePersist
    private void init() {
        createdAt = LocalDateTime.now();
    }
}

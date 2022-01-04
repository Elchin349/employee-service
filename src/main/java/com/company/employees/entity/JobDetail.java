package com.company.employees.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "job_details")
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
    @Column(name = "salary")
    private BigDecimal salary;
    @OneToOne(mappedBy = "jobDetail")
    private Employee employee;

    @PrePersist
    private void init(){
        createdAt = LocalDateTime.now();
    }
}

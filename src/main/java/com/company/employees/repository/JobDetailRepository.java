package com.company.employees.repository;

import com.company.employees.entity.JobDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface JobDetailRepository extends JpaRepository<JobDetail, Long> {

    List<JobDetail> getByCurrentSalaryBetween(BigDecimal min, BigDecimal max);
}

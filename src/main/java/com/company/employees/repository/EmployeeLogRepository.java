package com.company.employees.repository;

import com.company.employees.entity.EmployeeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeLogRepository extends JpaRepository<EmployeeLog, Long> {

}

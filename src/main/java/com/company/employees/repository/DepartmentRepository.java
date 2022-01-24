package com.company.employees.repository;

import com.company.employees.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}

package com.company.employees.repository;

import com.company.employees.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}

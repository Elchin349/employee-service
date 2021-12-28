package com.company.employees.repository;

import com.company.employees.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

//    @Query("select d from Department d join d.employeeList where d.id=:departmentId")
//    Department findDetails(@Param("departmentId") Long id);

    @Query("select d from Department d join d.employeeList")
    List<Department> findAllByQuery();
}

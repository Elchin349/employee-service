package com.company.employees.repository;

import com.company.employees.dto.EmployeeCountResponse;
import com.company.employees.entity.Employee;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {

    @Query("select count(e) from Employee e")
    int countAllByDepartment();

    @Query("select count(e) from Employee e group by e.department.id")
    List<Integer> countAllEmployeesGroupByDepartment();

    @Query("select new com.company.employees.dto.EmployeeCountResponse(e.department.departmentName,count(e)) " +
            "from Employee e group by e.department.departmentName")
    List<EmployeeCountResponse> countAllEmployeesGroupByDepartmentV2();

    long countByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

    @Query("select e from Employee e where e.jobDetail.currentSalary between :min and :max order by e.id ")
    List<Employee> findEmployeeByCurrentSalary(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    List<Employee> getEmployeesByActiveIsTrue(Pageable pageable);
}

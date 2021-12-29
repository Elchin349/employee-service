package com.company.employees.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    @PrePersist
    public void init(){
        createdAt = LocalDateTime.now();
    }
}

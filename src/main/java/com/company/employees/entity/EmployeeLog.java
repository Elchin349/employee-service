package com.company.employees.entity;


import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "employee_logs")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class EmployeeLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "operationName")
    private String operationName;
    @Column(name = "service_name")
    private String serviceName;
    @Column(name = "username")
    private String username;
    @Column(name = "operation_time")
    private LocalDateTime operationTime;

    @Type(type = "jsonb")
    @Column(name = "data", columnDefinition = "jsonb")
    private LogJsonBRecord data;
}

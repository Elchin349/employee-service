package com.company.employees.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Lob
    @Column(name = "data",columnDefinition = "CLOB")
    private byte[] data;

    private String type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @PrePersist
    public void init() {
        createAt = LocalDateTime.now();
    }
}

package com.company.employees.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address_line_1")
    public String addressLine1;

    @Column(name = "address_line_2")
    public String addressLine2;

    @Column(name = "country")
    public String country;

    @Column(name = "city")
    public String city;


    @OneToOne()
    @JoinColumn(name = "employee_id")
    public Employee employee;

//    @OneToOne(mappedBy = "address")
//    public Employee employee;
}

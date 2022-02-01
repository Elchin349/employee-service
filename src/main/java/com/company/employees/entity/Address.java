package com.company.employees.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table(name = "addresses")
@Getter
@Setter
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    public Employee employee;
}

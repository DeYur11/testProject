package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee", indexes = {
        @Index(name = "position_type_id", columnList = "position_type_id"),
        @Index(name = "pizzeria_id", columnList = "pizzeria_id")
})
public class Employee {
    @Id
    @Column(name = "employee_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "position_type_id", nullable = false)
    private PositionType positionType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pizzeria_id", nullable = false)
    private Pizzeria pizzeria;

}
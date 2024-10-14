package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pizzeria", indexes = {
        @Index(name = "idx_street_id", columnList = "street_id")
})
public class Pizzeria {
    @Id
    @Column(name = "pizzeria_id", nullable = false)
    private Integer id;

    @Column(name = "street_id", nullable = false)
    private Integer streetId;

    @Column(name = "building_number", nullable = false, length = 5)
    private String buildingNumber;

}
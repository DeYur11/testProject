package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "crust", indexes = {
        @Index(name = "Crusts_index_0", columnList = "name")
}, uniqueConstraints = {
        @UniqueConstraint(name = "name", columnNames = {"name"})
})
public class Crust {
    @Id
    @Column(name = "crust_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

}
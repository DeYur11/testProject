package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "pizza_size")
public class PizzaSize {
    @Id
    @Column(name = "pizza_size_id", nullable = false)
    private Integer id;

    @Column(name = "diameter", nullable = false)
    private Integer diameter;

    @Column(name = "size_cost_factor", nullable = false, precision = 10, scale = 2)
    private BigDecimal sizeCostFactor;

}
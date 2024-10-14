package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "base_pizza", indexes = {
        @Index(name = "Pizza_index_0", columnList = "name"),
        @Index(name = "pizza_type_id", columnList = "pizza_type_id")
}, uniqueConstraints = {
        @UniqueConstraint(name = "name", columnNames = {"name"})
})
public class BasePizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizza_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "price", nullable = false, precision = 6, scale = 2)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pizza_type_id", nullable = false)
    private PizzaType pizzaType;

}
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "custom_pizza", indexes = {
        @Index(name = "pizza_size_id", columnList = "pizza_size_id"),
        @Index(name = "crust_size_id", columnList = "crust_size_id"),
        @Index(name = "bake_style_id", columnList = "bake_style_id"),
        @Index(name = "base_pizza_id", columnList = "base_pizza_id")
})
public class CustomPizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custom_pizza_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pizza_size_id", nullable = false)
    private PizzaSize pizzaSize;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "crust_size_id", nullable = false)
    private Crust crustSize;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bake_style_id", nullable = false)
    private BakeStyle bakeStyle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "base_pizza_id", nullable = false)
    private BasePizza basePizza;

}
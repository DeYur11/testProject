package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "ingredient", indexes = {
        @Index(name = "ingredient_type_id", columnList = "ingredient_type_id")
})
public class Ingredient {
    @Id
    @Column(name = "ingredient_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "image_file_name", length = 1000)
    private String imageFileName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ingredient_type_id", nullable = false)
    private IngredientType ingredientType;

}
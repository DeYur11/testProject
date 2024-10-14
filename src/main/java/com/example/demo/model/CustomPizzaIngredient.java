package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "custom_pizza_ingredient", indexes = {
        @Index(name = "ingredient_id", columnList = "ingredient_id")
})
public class CustomPizzaIngredient {
    @EmbeddedId
    private CustomPizzaIngredientId id;

    @MapsId("customPizzaId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "custom_pizza_id", nullable = false)
    private CustomPizza customPizza;

    @MapsId("ingredientId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}
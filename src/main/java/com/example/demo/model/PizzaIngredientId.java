package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PizzaIngredientId implements Serializable {
    private static final long serialVersionUID = -2219212262944445252L;
    @Column(name = "pizza_id", nullable = false)
    private Integer pizzaId;

    @Column(name = "ingredient_id", nullable = false)
    private Integer ingredientId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PizzaIngredientId entity = (PizzaIngredientId) o;
        return Objects.equals(this.ingredientId, entity.ingredientId) &&
                Objects.equals(this.pizzaId, entity.pizzaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientId, pizzaId);
    }

}
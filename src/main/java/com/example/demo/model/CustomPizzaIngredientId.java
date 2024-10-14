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
public class CustomPizzaIngredientId implements Serializable {
    private static final long serialVersionUID = 418711473117121428L;
    @Column(name = "custom_pizza_id", nullable = false)
    private Integer customPizzaId;

    @Column(name = "ingredient_id", nullable = false)
    private Integer ingredientId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CustomPizzaIngredientId entity = (CustomPizzaIngredientId) o;
        return Objects.equals(this.ingredientId, entity.ingredientId) &&
                Objects.equals(this.customPizzaId, entity.customPizzaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientId, customPizzaId);
    }

}
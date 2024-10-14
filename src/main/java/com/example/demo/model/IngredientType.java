package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ingredient_type", indexes = {
        @Index(name = "Ingredient_type_index_0", columnList = "name")
}, uniqueConstraints = {
        @UniqueConstraint(name = "name", columnNames = {"name"})
})
public class IngredientType {
    @Id
    @Column(name = "ingredient_type_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

}
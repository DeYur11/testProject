package com.example.demo.repositories;

import com.example.demo.model.PizzaIngredient;
import com.example.demo.model.PizzaIngredientId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaIngredientRepository extends JpaRepository<PizzaIngredient, PizzaIngredientId> {
}
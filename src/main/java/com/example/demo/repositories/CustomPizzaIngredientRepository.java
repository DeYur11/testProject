package com.example.demo.repositories;

import com.example.demo.model.CustomPizzaIngredient;
import com.example.demo.model.CustomPizzaIngredientId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomPizzaIngredientRepository extends JpaRepository<CustomPizzaIngredient, CustomPizzaIngredientId> {
}
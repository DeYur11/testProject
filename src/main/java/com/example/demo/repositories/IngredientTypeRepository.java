package com.example.demo.repositories;

import com.example.demo.model.IngredientType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientTypeRepository extends JpaRepository<IngredientType, Integer> {
}
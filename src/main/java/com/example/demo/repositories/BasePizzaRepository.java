package com.example.demo.repositories;

import com.example.demo.model.BasePizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasePizzaRepository extends JpaRepository<BasePizza, Integer> {
}
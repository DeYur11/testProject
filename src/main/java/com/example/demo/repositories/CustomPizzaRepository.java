package com.example.demo.repositories;

import com.example.demo.model.CustomPizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomPizzaRepository extends JpaRepository<CustomPizza, Integer> {
}
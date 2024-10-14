package com.example.demo.repositories;

import com.example.demo.model.PizzaSize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaSizeRepository extends JpaRepository<PizzaSize, Integer> {
}
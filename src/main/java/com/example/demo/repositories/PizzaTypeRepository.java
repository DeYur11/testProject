package com.example.demo.repositories;

import com.example.demo.model.PizzaType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaTypeRepository extends JpaRepository<PizzaType, Integer> {
}
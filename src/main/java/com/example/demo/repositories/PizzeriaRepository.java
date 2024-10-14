package com.example.demo.repositories;

import com.example.demo.model.Pizzeria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzeriaRepository extends JpaRepository<Pizzeria, Integer> {
}
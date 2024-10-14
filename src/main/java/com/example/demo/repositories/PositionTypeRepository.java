package com.example.demo.repositories;

import com.example.demo.model.PositionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionTypeRepository extends JpaRepository<PositionType, Integer> {
}
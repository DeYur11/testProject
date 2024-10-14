package com.example.demo.repositories;

import com.example.demo.model.BakeStyle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BakeStyleRepository extends JpaRepository<BakeStyle, Integer> {
}
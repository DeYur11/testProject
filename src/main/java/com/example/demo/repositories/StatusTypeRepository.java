package com.example.demo.repositories;

import com.example.demo.model.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusTypeRepository extends JpaRepository<StatusType, Integer> {
}
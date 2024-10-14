package com.example.demo.repositories;

import com.example.demo.model.StatusOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusOrderRepository extends JpaRepository<StatusOrder, Integer> {
}
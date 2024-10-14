package com.example.demo.repositories;

import com.example.demo.model.Crust;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrustRepository extends JpaRepository<Crust, Integer> {
}
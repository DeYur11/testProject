package com.example.demo.repositories;

import com.example.demo.model.CookingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookingRecordRepository extends JpaRepository<CookingRecord, Integer> {
}
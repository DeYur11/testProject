package com.example.demo.repositories;

import com.example.demo.model.ContactType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactTypeRepository extends JpaRepository<ContactType, Integer> {
}
package com.example.CRUD.Operations.repository;

import com.example.CRUD.Operations.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport, Long> {
}
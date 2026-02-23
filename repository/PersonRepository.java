package com.example.CRUD.Operations.repository;

import com.example.CRUD.Operations.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
package com.example.CRUD.Operations.repository;

import com.example.CRUD.Operations.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByPersonsId(Long personId);
}
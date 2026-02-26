package com.example.CRUD.Operations.service;

import com.example.CRUD.Operations.model.Skill;
import com.example.CRUD.Operations.repository.SkillRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillService {

    private final SkillRepository repo;

    public SkillService(SkillRepository repo) {
        this.repo = repo;
    }

    public Skill save(Skill s) {
        return repo.save(s);
    }

    public List<Skill> getAll() {
        return repo.findAll();
    }
}
package com.example.CRUD.Operations.service;

import com.example.CRUD.Operations.model.Skill;
import com.example.CRUD.Operations.repository.SkillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private static final Logger log =
            LoggerFactory.getLogger(SkillService.class);

    private final SkillRepository repo;

    public SkillService(SkillRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public Skill save(Skill s) {
        log.info("SERVICE -> Saving skill {}", s.getName());
        return repo.save(s);
    }

    // GET ALL
    public List<Skill> getAll() {
        return repo.findAll();
    }

    // GET BY ID
    public Skill getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
    }

    // UPDATE
    public Skill update(Long id, Skill s) {
        Skill existing = getById(id);

        existing.setName(s.getName());

        if (s.getPersons() != null) {
            existing.setPersons(s.getPersons());
        }

        return repo.save(existing);
    }

    // DELETE
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
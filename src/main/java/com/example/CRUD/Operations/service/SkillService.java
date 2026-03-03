package com.example.CRUD.Operations.service;

import com.example.CRUD.Operations.dto.SkillDTO;
import com.example.CRUD.Operations.dto.SkillRequestDTO;
import com.example.CRUD.Operations.mapper.SkillMapper;
import com.example.CRUD.Operations.model.Person;
import com.example.CRUD.Operations.model.Skill;
import com.example.CRUD.Operations.repository.PersonRepository;
import com.example.CRUD.Operations.repository.SkillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SkillService {

    private static final Logger log =
            LoggerFactory.getLogger(SkillService.class);

    private final SkillRepository repo;
    private final PersonRepository personRepo;

    public SkillService(SkillRepository repo, PersonRepository personRepo) {
        this.repo = repo;
        this.personRepo = personRepo;
    }

    // CREATE from request DTO
    public SkillDTO createFromRequest(SkillRequestDTO request) {
        log.info("SERVICE -> Saving skill {}", request.getName());

        Skill skill = new Skill();
        skill.setName(request.getName());

        if (request.getPersonIds() != null && !request.getPersonIds().isEmpty()) {
            List<Person> persons = personRepo.findAllById(request.getPersonIds());
            Set<Person> unique = new HashSet<>(persons);
            skill.setPersons(unique);
        }

        Skill saved = repo.save(skill);
        return SkillMapper.toDTO(saved);
    }

    // CREATE (keep if you want)
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
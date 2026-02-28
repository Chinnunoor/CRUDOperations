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

    public Skill save(Skill s) {

        log.info("SERVICE -> Saving skill | name={}",
                s.getName());

        Skill saved = repo.save(s);

        log.info("SERVICE <- Skill saved | id={}",
                saved.getId());

        return saved;
    }

    public List<Skill> getAll() {

        log.info("SERVICE -> Fetching all skills");

        List<Skill> list = repo.findAll();

        log.info("SERVICE <- Total skills fetched = {}",
                list.size());

        return list;
    }
}
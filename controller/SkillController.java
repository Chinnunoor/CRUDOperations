package com.example.CRUD.Operations.controller;

import com.example.CRUD.Operations.model.Skill;
import com.example.CRUD.Operations.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private static final Logger log =
            LoggerFactory.getLogger(SkillController.class);

    @Autowired
    private SkillService service;

    @PostMapping
    public Skill create(@RequestBody Skill s) {

        log.info("CONTROLLER -> Received POST /skills | name={}",
                s.getName());

        Skill saved = service.save(s);

        log.info("CONTROLLER <- Returning response for POST /skills | id={}",
                saved.getId());

        return saved;
    }

    @GetMapping
    public List<Skill> getAll() {

        log.info("CONTROLLER -> Received GET /skills");

        List<Skill> skills = service.getAll();

        log.info("CONTROLLER <- Returning response for GET /skills | count={}",
                skills.size());

        return skills;
    }
}
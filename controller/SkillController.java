package com.example.CRUD.Operations.controller;

import com.example.CRUD.Operations.model.Skill;
import com.example.CRUD.Operations.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    private  SkillService service;


    @PostMapping
    public Skill create(@RequestBody Skill s) {
        return service.save(s);
    }

    @GetMapping
    public List<Skill> getAll() {
        return service.getAll();
    }
}
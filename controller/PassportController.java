package com.example.CRUD.Operations.controller;

import com.example.CRUD.Operations.model.Passport;
import com.example.CRUD.Operations.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passports")
public class PassportController {


    @Autowired
    private PassportService service;


    @PostMapping
    public Passport create(@RequestBody Passport p) {
        return service.save(p);
    }

    @GetMapping
    public List<Passport> getAll() {
        return service.getAll();
    }
}
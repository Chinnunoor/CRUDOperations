package com.example.CRUD.Operations.controller;

import com.example.CRUD.Operations.model.Person;
import com.example.CRUD.Operations.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public Person create(@RequestBody Person p) {
        return service.save(p);
    }

    @GetMapping
    public List<Person> getAll() {
        return service.getAll();
    }
}
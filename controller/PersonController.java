package com.example.CRUD.Operations.controller;

import com.example.CRUD.Operations.exception.PersonNotFoundException;
import com.example.CRUD.Operations.model.Person;
import com.example.CRUD.Operations.service.PersonService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService service;

    @PostMapping
    public Person create(@Valid @RequestBody Person p) {

        log.info("CONTROLLER -> Received POST /persons | firstName={}, lastName={}",
                p.getFirstName(), p.getLastName());

        Person saved = service.saveData(p);

        log.info("CONTROLLER <- Returning response for POST /persons | id={}", saved.getId());
        return saved;
    }

    @GetMapping
    public List<Person> getAll() {
        log.info("CONTROLLER -> Received GET /persons");

        List<Person> persons = service.getAll();

        log.info("CONTROLLER <- Returning response for GET /persons | count={}", persons.size());
        return persons;
    }
    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id) {
        log.info("CONTROLLER -> GET /persons/{}", id);

        Person person = service.getById(id);

        log.info("CONTROLLER <- Returning person {}", person.getId());
        return person;
    }
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id,
                               @Valid @RequestBody Person person) {

        log.info("CONTROLLER -> PUT /persons/{}", id);

        return service.update(id, person);
    }
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {

        log.info("CONTROLLER -> DELETE /persons/{}", id);

        service.delete(id);
    }
}
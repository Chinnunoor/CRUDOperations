//package com.example.CRUD.Operations.controller;
//
//import com.example.CRUD.Operations.model.Person;
//import com.example.CRUD.Operations.service.PersonService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/persons")
//public class PersonController {
//
//    private final PersonService service;
//
//    public PersonController(PersonService service) {
//        this.service = service;
//    }
//
//    @PostMapping
//    public Person create(@RequestBody Person p) {
//        return service.save(p);
//    }
//
//    @GetMapping
//    public List<Person> getAll() {
//        return service.getAll();
//    }
//}
package com.example.CRUD.Operations.controller;

import com.example.CRUD.Operations.model.Person;
import com.example.CRUD.Operations.repository.PersonRepository;
import com.example.CRUD.Operations.service.PersonService;
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
    public Person create(@RequestBody Person p) {

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
}
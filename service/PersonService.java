package com.example.CRUD.Operations.service;

import com.example.CRUD.Operations.model.Person;
import com.example.CRUD.Operations.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository repo;

    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    public Person save(Person p) {
        return repo.save(p);
    }

    public List<Person> getAll() {
        return repo.findAll();
    }
}
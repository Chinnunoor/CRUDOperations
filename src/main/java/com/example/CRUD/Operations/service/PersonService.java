package com.example.CRUD.Operations.service;

import com.example.CRUD.Operations.exception.PersonNotFoundException;
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
public class PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    private final PersonRepository repo;
    private final SkillRepository skillRepository;

    public PersonService(PersonRepository repo, SkillRepository skillRepository) {
        this.repo = repo;
        this.skillRepository = skillRepository;
    }

    // CREATE
    public Person saveData(Person p, Set<Long> skillIds) {

        log.info("SERVICE -> Saving person | firstName={}, lastName={}",
                p.getFirstName(), p.getLastName());

        // Link Passport -> Person
        if (p.getPassport() != null) {
            p.getPassport().setPerson(p);
        }

        // Attach Skills if provided
        if (skillIds != null && !skillIds.isEmpty()) {
            Set<Skill> skills = new HashSet<>(skillRepository.findAllById(skillIds));
            p.setSkills(skills);
        }

        Person saved = repo.save(p);

        log.info("SERVICE <- Person saved successfully | id={}", saved.getId());
        return saved;
    }

    // READ ALL
    public List<Person> getAll() {
        log.info("SERVICE -> Fetching all persons");
        return repo.findAll();
    }

    // READ BY ID
    public Person getById(Long id) {

        log.info("SERVICE -> Fetching person id={}", id);

        return repo.findById(id)
                .orElseThrow(() ->
                        new PersonNotFoundException("Person not found with id: " + id));
    }

    // UPDATE (WITH SKILLS SUPPORT)
    public Person update(Long id, Person updatedPerson, Set<Long> skillIds) {

        log.info("SERVICE -> Updating person id={}", id);

        Person existing = repo.findById(id)
                .orElseThrow(() ->
                        new PersonNotFoundException("Person not found with id: " + id));

        // Update basic fields
        existing.setFirstName(updatedPerson.getFirstName());
        existing.setLastName(updatedPerson.getLastName());
        existing.setDateOfBirth(updatedPerson.getDateOfBirth());
        existing.setPhoneNumber(updatedPerson.getPhoneNumber());
        existing.setAddress(updatedPerson.getAddress());
        existing.setLocation(updatedPerson.getLocation());

        // Attach Skills
        if (skillIds != null) {
            Set<Skill> skills = new HashSet<>(skillRepository.findAllById(skillIds));
            existing.setSkills(skills);
        }

        Person saved = repo.save(existing);

        log.info("SERVICE <- Person updated successfully id={}", saved.getId());
        return saved;
    }

    // DELETE
    public void delete(Long id) {

        log.info("SERVICE -> Deleting person id={}", id);

        Person person = repo.findById(id)
                .orElseThrow(() ->
                        new PersonNotFoundException("Person not found with id: " + id));

        repo.delete(person);

        log.info("SERVICE <- Person deleted id={}", id);
    }
}
//package com.example.CRUD.Operations.service;
//
//import com.example.CRUD.Operations.exception.PersonNotFoundException;
//import com.example.CRUD.Operations.model.Person;
//import com.example.CRUD.Operations.repository.PersonRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//
//@Service
//public class PersonService {
//
//    private static final Logger log = LoggerFactory.getLogger(PersonService.class);
//    private final PersonRepository repo;
//
//    public PersonService(PersonRepository repo)
//    {
//        this.repo = repo;
//    }
//
//    public Person saveData(Person p) {
//        log.info("SERVICE -> Saving person to DB | firstName={}, lastName={}",
//                p.getFirstName(), p.getLastName());
//        //link Passport -> Person (because person_id is NOT NULL)
//        if (p.getPassport() != null) {
//            p.getPassport().setPerson(p);
//        }
//
//        Person saved = repo.save(p);//insert into persons (address,date_of_birth,first_name,last_name,location,phone_number) values (?,?,?,?,?,?)
//
//        log.info("SERVICE <- Person saved successfully | id={}", saved.getId());
//        return saved;
//    }
//
//    public List<Person> getAll() {
//        log.info("SERVICE -> Fetching all persons from DB");
//        List<Person> persons = repo.findAll(); //select a1_0.person_id,a1_0.id,a1_0.city,a1_0.line1,a1_0.state,a1_0.zip from address a1_0 where a1_0.person_id=?
//        log.info("SERVICE <- Total persons fetched = {}", persons.size());
//        return persons;
//    }
//    public Person update(Long id, Person updatedPerson) {
//
//        log.info("SERVICE -> Updating person with id={}", id);
//
//        Person existing = repo.findById(id)
//                .orElseThrow(() ->
//                        new PersonNotFoundException("Person not found with id: " + id));
//
//        // update fields
//        existing.setFirstName(updatedPerson.getFirstName());
//        existing.setLastName(updatedPerson.getLastName());
//        existing.setDateOfBirth(updatedPerson.getDateOfBirth());
//        existing.setPhoneNumber(updatedPerson.getPhoneNumber());
//        existing.setAddress(updatedPerson.getAddress());
//        existing.setLocation(updatedPerson.getLocation());
//
//        Person saved = repo.save(existing);
//
//        log.info("SERVICE <- Person updated successfully id={}", saved.getId());
//
//        return saved;
//    }
//    public void delete(Long id) {
//
//        log.info("SERVICE -> Deleting person id={}", id);
//
//        Person person = repo.findById(id)
//                .orElseThrow(() ->
//                        new PersonNotFoundException("Person not found with id: " + id));
//
//        repo.delete(person);
//
//        log.info("SERVICE <- Person deleted id={}", id);
//    }
//    }
//    // NEW METHOD (exception handling)
//    public Person getById(Long id) //fetch person using id
//    {
//        log.info("SERVICE -> Fetching person by id={}", id);
//
//        Person person = repo.findById(id)
//                .orElseThrow(() -> new PersonNotFoundException("Person not found with id: " + id));
//
//        log.info("SERVICE <- Person found | id={}", person.getId());
//        return person;
//    }
//}
package com.example.CRUD.Operations.service;

import com.example.CRUD.Operations.exception.PersonNotFoundException;
import com.example.CRUD.Operations.model.Person;
import com.example.CRUD.Operations.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    private final PersonRepository repo;

    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    //  CREATE
    public Person saveData(Person p)  //insert into persons (address,date_of_birth,first_name,last_name,location,phone_number) values (?,?,?,?,?,?)
    {
        log.info("SERVICE -> Saving person to DB | firstName={}, lastName={}",
                p.getFirstName(), p.getLastName());

        // link Passport -> Person (because person_id is NOT NULL)
        if (p.getPassport() != null) {
            p.getPassport().setPerson(p);
        }

        Person saved = repo.save(p);

        log.info("SERVICE <- Person saved successfully | id={}", saved.getId());
        return saved;
    }

    //  READ ALL
    public List<Person> getAll() {
        log.info("SERVICE -> Fetching all persons from DB");

        List<Person> persons = repo.findAll(); //select a1_0.person_id,a1_0.id,a1_0.city,a1_0.line1,a1_0.state,a1_0.zip from address a1_0 where a1_0.person_id=?

        log.info("SERVICE <- Total persons fetched = {}", persons.size());
        return persons;
    }

    // READ BY ID(exception handling)

    public Person getById(Long id) //fetch person using id
    {
        log.info("SERVICE -> Fetching person by id={}", id);

        Person person = repo.findById(id)
                .orElseThrow(() ->
                        new PersonNotFoundException("Person not found with id: " + id));

        log.info("SERVICE <- Person found | id={}", person.getId());
        return person;
    }

    // UPDATE
    public Person update(Long id, Person updatedPerson) {

        log.info("SERVICE -> Updating person with id={}", id);

        Person existing = repo.findById(id)
                .orElseThrow(() ->
                        new PersonNotFoundException("Person not found with id: " + id));

        // update fields
        existing.setFirstName(updatedPerson.getFirstName());
        existing.setLastName(updatedPerson.getLastName());
        existing.setDateOfBirth(updatedPerson.getDateOfBirth());
        existing.setPhoneNumber(updatedPerson.getPhoneNumber());
        existing.setAddress(updatedPerson.getAddress());
        existing.setLocation(updatedPerson.getLocation());

        Person saved = repo.save(existing);

        log.info("SERVICE <- Person updated successfully id={}", saved.getId());
        return saved;
    }

    //  DELETE
    public void delete(Long id) {

        log.info("SERVICE -> Deleting person id={}", id);

        Person person = repo.findById(id)
                .orElseThrow(() ->
                        new PersonNotFoundException("Person not found with id: " + id));

        repo.delete(person);

        log.info("SERVICE <- Person deleted id={}", id);
    }
}
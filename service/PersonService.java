//package com.example.CRUD.Operations.service;
//
//import com.example.CRUD.Operations.model.Person;
//import com.example.CRUD.Operations.repository.PersonRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class PersonService {
//
//    private final PersonRepository repo;
//
//    public PersonService(PersonRepository repo) {
//        this.repo = repo;
//    }
//
//    public Person save(Person p) {
//        return repo.save(p);
//    }
//
//    public List<Person> getAll() {
//        return repo.findAll();
//    }
//}
package com.example.CRUD.Operations.service;

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

    public Person saveData(Person p) {
        log.info("SERVICE -> Saving person to DB | firstName={}, lastName={}",
                p.getFirstName(), p.getLastName());

        Person saved = repo.save(p);//insert into persons (address,date_of_birth,first_name,last_name,location,phone_number) values (?,?,?,?,?,?)

        log.info("SERVICE <- Person saved successfully | id={}", saved.getId());
        return saved;
    }

    public List<Person> getAll() {
        log.info("SERVICE -> Fetching all persons from DB");
        List<Person> persons = repo.findAll(); //select a1_0.person_id,a1_0.id,a1_0.city,a1_0.line1,a1_0.state,a1_0.zip from address a1_0 where a1_0.person_id=?
        log.info("SERVICE <- Total persons fetched = {}", persons.size());
        return persons;
    }
}
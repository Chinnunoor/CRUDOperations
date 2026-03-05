package com.example.CRUD.Operations.controller;
import com.example.CRUD.Operations.dto.PersonDTO;
import com.example.CRUD.Operations.mapper.PersonMapper;
import com.example.CRUD.Operations.model.Person;
import com.example.CRUD.Operations.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    private PersonService service; // injecting to person service

    @PostMapping
    public PersonDTO create(@Valid @RequestBody PersonDTO dto) {

        log.info("CONTROLLER -> Received POST /persons | firstName={}, lastName={}",
                dto.getFirstName(), dto.getLastName());

        Person saved = service.saveData(PersonMapper.toEntity(dto), dto.getSkillIds()
        );

        log.info("CONTROLLER <- Returning response for POST /persons | id={}", saved.getId());
        return PersonMapper.toDTO(saved);
    }

    @GetMapping
    public Page<PersonDTO> getAll(Pageable pageable) {

        log.info("CONTROLLER -> Received GET /persons with pagination");

        Page<Person> page = service.getAll(pageable);

        Page<PersonDTO> dtoPage = page.map(PersonMapper::toDTO);

        log.info("CONTROLLER <- Returning paginated response");

        return dtoPage;
    }
    @GetMapping("/{id}")
    public PersonDTO getById(@PathVariable Long id) {
        log.info("CONTROLLER -> GET /persons/{}", id);

        Person person = service.getById(id);

        log.info("CONTROLLER <- Returning person {}", person.getId());
        return PersonMapper.toDTO(person);
    }
    @PutMapping("/{id}")
    public PersonDTO updatePerson(@PathVariable Long id,
                               @Valid @RequestBody PersonDTO dto) {

        log.info("CONTROLLER -> PUT /persons/{}", id);
        Person updated = service.update(
                id,
                PersonMapper.toEntity(dto),
                dto.getSkillIds()
        );

        return PersonMapper.toDTO(updated);
    }
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {

        log.info("CONTROLLER -> DELETE /persons/{}", id);

        service.delete(id);
    }
}
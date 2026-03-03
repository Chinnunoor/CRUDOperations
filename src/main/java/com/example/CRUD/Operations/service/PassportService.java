package com.example.CRUD.Operations.service;

import com.example.CRUD.Operations.model.Passport;
import com.example.CRUD.Operations.repository.PassportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportService {

    private static final Logger log =
            LoggerFactory.getLogger(PassportService.class);

    private final PassportRepository repo;

    public PassportService(PassportRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public Passport save(Passport p) {

        log.info("SERVICE -> Saving passport | number={}", p.getPassportNumber());

        Passport saved = repo.save(p);

        log.info("SERVICE <- Passport saved | id={}", saved.getId());

        return saved;
    }

    // GET ALL
    public List<Passport> getAll() {

        log.info("SERVICE -> Fetching all passports");

        return repo.findAll();
    }

    // GET BY ID
    public Passport getById(Long id) {

        log.info("SERVICE -> Fetching passport {}", id);

        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Passport not found"));
    }

    // UPDATE
    public Passport update(Long id, Passport p) {

        Passport existing = getById(id);

        existing.setPassportNumber(p.getPassportNumber());
        existing.setCountry(p.getCountry());

        if (p.getPerson() != null) {
            existing.setPerson(p.getPerson());
        }

        return repo.save(existing);
    }

    // DELETE
    public void delete(Long id) {

        log.info("SERVICE -> Deleting passport {}", id);

        repo.deleteById(id);
    }
}
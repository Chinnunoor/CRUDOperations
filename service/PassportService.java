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

    public Passport save(Passport p) {

        log.info("SERVICE -> Saving passport | number={}",
                p.getPassportNumber());

        Passport saved = repo.save(p);

        log.info("SERVICE <- Passport saved | id={}",
                saved.getId());

        return saved;
    }

    public List<Passport> getAll() {

        log.info("SERVICE -> Fetching all passports");

        List<Passport> list = repo.findAll();

        log.info("SERVICE <- Total passports fetched = {}",
                list.size());

        return list;
    }
}
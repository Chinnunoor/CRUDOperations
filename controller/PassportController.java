package com.example.CRUD.Operations.controller;

import com.example.CRUD.Operations.model.Passport;
import com.example.CRUD.Operations.service.PassportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passports")
public class PassportController {

    private static final Logger log =
            LoggerFactory.getLogger(PassportController.class);

    @Autowired
    private PassportService service;

    @PostMapping
    public Passport create(@RequestBody Passport p) {

        log.info("CONTROLLER -> Received POST /passports | passportNumber={}, country={}",
                p.getPassportNumber(), p.getCountry());

        Passport saved = service.save(p);

        log.info("CONTROLLER <- Returning response for POST /passports | id={}",
                saved.getId());

        return saved;
    }

    @GetMapping
    public List<Passport> getAll() {

        log.info("CONTROLLER -> Received GET /passports");

        List<Passport> passports = service.getAll();

        log.info("CONTROLLER <- Returning response for GET /passports | count={}",
                passports.size());

        return passports;
    }
}
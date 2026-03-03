package com.example.CRUD.Operations.controller;

import com.example.CRUD.Operations.dto.PassportDTO;
import com.example.CRUD.Operations.mapper.PassportMapper;
import com.example.CRUD.Operations.model.Passport;
import com.example.CRUD.Operations.service.PassportService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passports")
public class PassportController {

    private static final Logger log =
            LoggerFactory.getLogger(PassportController.class);

    private final PassportService service;

    public PassportController(PassportService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public PassportDTO create(@Valid @RequestBody PassportDTO dto) {

        log.info("CONTROLLER -> POST /passports | passportNumber={}, country={}",
                dto.getPassportNumber(), dto.getCountry());

        Passport saved = service.save(PassportMapper.toEntity(dto));

        log.info("CONTROLLER <- Passport created id={}", saved.getId());

        return PassportMapper.toDTO(saved);
    }

    // GET ALL
    @GetMapping
    public List<PassportDTO> getAll() {

        log.info("CONTROLLER -> GET /passports");

        return service.getAll()
                .stream()
                .map(PassportMapper::toDTO)
                .toList();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public PassportDTO getById(@PathVariable Long id) {

        log.info("CONTROLLER -> GET /passports/{}", id);

        Passport passport = service.getById(id);

        return PassportMapper.toDTO(passport);
    }

    // UPDATE
    @PutMapping("/{id}")
    public PassportDTO update(@PathVariable Long id,
                              @Valid @RequestBody PassportDTO dto) {

        log.info("CONTROLLER -> PUT /passports/{}", id);

        Passport updated =
                service.update(id, PassportMapper.toEntity(dto));

        return PassportMapper.toDTO(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        log.info("CONTROLLER -> DELETE /passports/{}", id);

        service.delete(id);
    }
}
package com.example.CRUD.Operations.controller;

import com.example.CRUD.Operations.dto.SkillDTO;
import com.example.CRUD.Operations.mapper.SkillMapper;
import com.example.CRUD.Operations.model.Skill;
import com.example.CRUD.Operations.service.SkillService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private static final Logger log =
            LoggerFactory.getLogger(SkillController.class);

    private final SkillService service;

    public SkillController(SkillService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public SkillDTO create(@Valid @RequestBody SkillDTO dto) {

        log.info("CONTROLLER -> POST /skills {}", dto.getName());

        Skill saved =
                service.save(SkillMapper.toEntity(dto));

        return SkillMapper.toDTO(saved);
    }

    // GET ALL
    @GetMapping
    public List<SkillDTO> getAll() {

        log.info("CONTROLLER -> GET /skills");

        return service.getAll()
                .stream()
                .map(SkillMapper::toDTO)
                .toList();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public SkillDTO getById(@PathVariable Long id) {

        return SkillMapper.toDTO(service.getById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public SkillDTO update(@PathVariable Long id,
                           @Valid @RequestBody SkillDTO dto) {

        Skill updated =
                service.update(id, SkillMapper.toEntity(dto));

        return SkillMapper.toDTO(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
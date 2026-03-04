//package com.example.CRUD.Operations.controller;
//
//import com.example.CRUD.Operations.dto.SkillRequestDTO;
//import com.example.CRUD.Operations.dto.SkillDTO;
//import com.example.CRUD.Operations.mapper.SkillMapper;
//import com.example.CRUD.Operations.model.Skill;
//import com.example.CRUD.Operations.service.SkillService;
//import jakarta.validation.Valid;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/skills")
//public class SkillController {
//
//    private static final Logger log =
//            LoggerFactory.getLogger(SkillController.class);
//
//    private final SkillService service;
//
//    public SkillController(SkillService service) {
//        this.service = service;
//    }
//
//    // CREATE
//    @PostMapping
//    public SkillDTO create(@Valid @RequestBody SkillRequestDTO request) {
//
//        log.info("CONTROLLER -> POST /skills {}", request.getName());
//
//        return service.createSkill(request);
//    }
//    // GET ALL
//    @GetMapping
//    public List<SkillDTO> getAll() {
//
//        log.info("CONTROLLER -> GET /skills");
//
//        return service.getAll()
//                .stream()
//                .map(SkillMapper::toDTO)
//                .toList();
//    }
//
//    // GET BY ID
//    @GetMapping("/{id}")
//    public SkillDTO getById(@PathVariable Long id) {
//
//        return SkillMapper.toDTO(service.getById(id));
//    }
//
//    // UPDATE
//    @PutMapping("/{id}")
//    public SkillDTO update(@PathVariable Long id,
//                           @Valid @RequestBody SkillDTO dto) {
//
//        Skill updated =
//                service.update(id, SkillMapper.toEntity(dto));
//
//        return SkillMapper.toDTO(updated);
//    }
//
//    // DELETE
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        service.delete(id);
//    }
//}
package com.example.CRUD.Operations.controller;

import com.example.CRUD.Operations.dto.SkillDTO;
import com.example.CRUD.Operations.dto.SkillRequestDTO;
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

    private static final Logger log = LoggerFactory.getLogger(SkillController.class);

    private final SkillService service;

    public SkillController(SkillService service) {
        this.service = service;
    }

    // CREATE (request body: { "name": "...", "personIds": [1,2] })
    @PostMapping
    public SkillDTO create(@Valid @RequestBody SkillRequestDTO request) {
        log.info("CONTROLLER -> POST /skills name={}", request.getName());
        return service.createFromRequest(request);
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
        log.info("CONTROLLER -> GET /skills/{}", id);
        return SkillMapper.toDTO(service.getById(id));
    }
    @GetMapping("/person/{personId}")
    public List<SkillDTO> getSkillsByPerson(@PathVariable Long personId) {

        return service.getByPersonId(personId)
                .stream()
                .map(SkillMapper::toDTO)
                .toList();
    }
    // UPDATE
    @PutMapping("/{id}")
    public SkillDTO update(@PathVariable Long id, @Valid @RequestBody SkillDTO dto) {
        log.info("CONTROLLER -> PUT /skills/{} name={}", id, dto.getName());
        Skill updated = service.update(id, SkillMapper.toEntity(dto));
        return SkillMapper.toDTO(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("CONTROLLER -> DELETE /skills/{}", id);
        service.delete(id);
    }
}
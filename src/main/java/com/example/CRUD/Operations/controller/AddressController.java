package com.example.CRUD.Operations.controller;

import com.example.CRUD.Operations.dto.AddressDTO;
import com.example.CRUD.Operations.mapper.AddressMapper;
import com.example.CRUD.Operations.model.Address;
import com.example.CRUD.Operations.service.AddressService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private static final Logger log =
            LoggerFactory.getLogger(AddressController.class);

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public AddressDTO create(@Valid @RequestBody AddressDTO dto) {

        log.info("CONTROLLER -> POST /addresses");

        Address saved =
                service.save(AddressMapper.toEntity(dto));

        return AddressMapper.toDTO(saved);
    }

    // GET ALL
    @GetMapping
    public List<AddressDTO> getAll() {

        log.info("CONTROLLER -> GET /addresses");

        return service.getAll()
                .stream()
                .map(AddressMapper::toDTO)
                .toList();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public AddressDTO getById(@PathVariable Long id) {

        log.info("CONTROLLER -> GET /addresses/{}", id);

        return AddressMapper.toDTO(service.getById(id));
    }
    @GetMapping("/person/{personId}")
    public List<AddressDTO> getByPersonId(@PathVariable Long personId) {

        log.info("CONTROLLER -> GET /addresses/person/{}", personId);

        return service.getByPersonId(personId)
                .stream()
                .map(AddressMapper::toDTO)
                .toList();
    }
    // UPDATE
    @PutMapping("/{id}")
    public AddressDTO update(@PathVariable Long id,
                             @Valid @RequestBody AddressDTO dto) {

        log.info("CONTROLLER -> PUT /addresses/{}", id);

        Address updated =
                service.update(id, AddressMapper.toEntity(dto));

        return AddressMapper.toDTO(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        log.info("CONTROLLER -> DELETE /addresses/{}", id);

        service.delete(id);
    }
}
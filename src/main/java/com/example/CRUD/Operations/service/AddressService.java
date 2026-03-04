package com.example.CRUD.Operations.service;

import com.example.CRUD.Operations.model.Address;
import com.example.CRUD.Operations.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private static final Logger log =
            LoggerFactory.getLogger(AddressService.class);

    private final AddressRepository repo;

    public AddressService(AddressRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public Address save(Address a) {
        log.info("SERVICE -> Saving address");
        return repo.save(a);
    }

    // GET ALL
    public List<Address> getAll() {
        log.info("SERVICE -> Fetching all addresses");
        return repo.findAll();
    }

    // GET BY ID
    public Address getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
    }
    public List<Address> getByPersonId(Long personId) {

        log.info("SERVICE -> Fetching addresses for personId={}", personId);

        return repo.findByPersonId(personId);
    }
    // UPDATE
    public Address update(Long id, Address a) {
        Address existing = getById(id);

        existing.setLine1(a.getLine1());
        existing.setCity(a.getCity());
        existing.setState(a.getState());
        existing.setZip(a.getZip());

        if (a.getPerson() != null) {
            existing.setPerson(a.getPerson());
        }

        return repo.save(existing);
    }

    // DELETE
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
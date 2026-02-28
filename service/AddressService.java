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

    public Address save(Address a) {

        log.info("SERVICE -> Saving address | city={}, state={}",
                a.getCity(), a.getState());

        Address saved = repo.save(a);

        log.info("SERVICE <- Address saved | id={}",
                saved.getId());

        return saved;
    }

    public List<Address> getAll() {

        log.info("SERVICE -> Fetching all addresses");

        List<Address> list = repo.findAll();

        log.info("SERVICE <- Total addresses fetched = {}",
                list.size());

        return list;
    }
}
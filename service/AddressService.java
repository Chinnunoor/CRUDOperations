package com.example.CRUD.Operations.service;

import com.example.CRUD.Operations.model.Address;
import com.example.CRUD.Operations.repository.AddressRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressService {

    private final AddressRepository repo;

    public AddressService(AddressRepository repo) {
        this.repo = repo;
    }

    public Address save(Address a) {
        return repo.save(a);
    }

    public List<Address> getAll() {
        return repo.findAll();
    }
}
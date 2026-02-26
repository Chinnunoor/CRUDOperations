package com.example.CRUD.Operations.service;

import com.example.CRUD.Operations.model.Passport;
import com.example.CRUD.Operations.repository.PassportRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PassportService {

    private final PassportRepository repo;

    public PassportService(PassportRepository repo) {
        this.repo = repo;
    }

    public Passport save(Passport p) {
        return repo.save(p);
    }

    public List<Passport> getAll() {
        return repo.findAll();
    }
}
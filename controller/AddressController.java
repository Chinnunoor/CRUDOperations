package com.example.CRUD.Operations.controller;

import com.example.CRUD.Operations.model.Address;
import com.example.CRUD.Operations.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService service; //Spring creates object for us if we annotate as @autowired

    @PostMapping
    public Address create(@RequestBody Address a) {
        return service.save(a);   //save means insert
    }

    @GetMapping
    public List<Address> getAll() {
        return service.getAll();
    }
}
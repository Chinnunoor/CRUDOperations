package com.example.CRUD.Operations.controller;

import com.example.CRUD.Operations.model.Address;
import com.example.CRUD.Operations.service.AddressService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private static final Logger log =
            LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressService service; //Spring creates object for us if we annotate as @autowired

    @PostMapping
    public Address create(@Valid @RequestBody Address a) {

        log.info("CONTROLLER -> Received POST /addresses | city={}, state={}",
                a.getCity(), a.getState());

        Address saved = service.save(a);

        log.info("CONTROLLER <- Returning response for POST /addresses | id={}",
                saved.getId());

        return saved; //save storing data to db
    }

    @GetMapping
    public List<Address> getAll() {

        log.info("CONTROLLER -> Received GET /addresses");

        List<Address> addresses = service.getAll();

        log.info("CONTROLLER <- Returning response for GET /addresses | count={}",
                addresses.size());

        return addresses;
    }
}
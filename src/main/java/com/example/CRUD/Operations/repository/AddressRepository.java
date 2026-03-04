package com.example.CRUD.Operations.repository;

import com.example.CRUD.Operations.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByPersonId(Long personId);
}
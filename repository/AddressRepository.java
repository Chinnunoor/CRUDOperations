package com.example.CRUD.Operations.repository;

import com.example.CRUD.Operations.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
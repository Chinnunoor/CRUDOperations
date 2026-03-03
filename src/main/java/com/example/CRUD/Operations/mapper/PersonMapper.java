package com.example.CRUD.Operations.mapper;

import com.example.CRUD.Operations.dto.PersonDTO;
import com.example.CRUD.Operations.model.Person;

public class PersonMapper {

    public static PersonDTO toDTO(Person p) {
        PersonDTO dto = new PersonDTO();
        dto.setId(p.getId());
        dto.setFirstName(p.getFirstName());
        dto.setLastName(p.getLastName());
        dto.setDateOfBirth(p.getDateOfBirth());
        dto.setPhoneNumber(p.getPhoneNumber());
        dto.setAddress(p.getAddress());
        dto.setLocation(p.getLocation());
        return dto;
    }

    public static Person toEntity(PersonDTO dto) {
        Person p = new Person();
        p.setId(dto.getId());
        p.setFirstName(dto.getFirstName());
        p.setLastName(dto.getLastName());
        p.setDateOfBirth(dto.getDateOfBirth());
        p.setPhoneNumber(dto.getPhoneNumber());
        p.setAddress(dto.getAddress());
        p.setLocation(dto.getLocation());
        return p;
    }
}
package com.example.CRUD.Operations.mapper;

import com.example.CRUD.Operations.dto.AddressDTO;
import com.example.CRUD.Operations.model.Address;
import com.example.CRUD.Operations.model.Person;

public class AddressMapper {

    public static AddressDTO toDTO(Address address) {
        if (address == null) return null;

        AddressDTO dto = new AddressDTO();
        dto.setId(address.getId());
        dto.setLine1(address.getLine1());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        dto.setZip(address.getZip());

        if (address.getPerson() != null) {
            dto.setPersonId(address.getPerson().getId());
        }

        return dto;
    }

    public static Address toEntity(AddressDTO dto) {
        if (dto == null) return null;

        Address address = new Address();
        address.setId(dto.getId());
        address.setLine1(dto.getLine1());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setZip(dto.getZip());

        if (dto.getPersonId() != null) {
            Person p = new Person();
            p.setId(dto.getPersonId());
            address.setPerson(p);
        }

        return address;
    }
}
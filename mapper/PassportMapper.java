package com.example.CRUD.Operations.mapper;

import com.example.CRUD.Operations.dto.PassportDTO;
import com.example.CRUD.Operations.model.Passport;
import com.example.CRUD.Operations.model.Person;

public class PassportMapper {

    // ENTITY -> DTO
    public static PassportDTO toDTO(Passport passport) {
        if (passport == null) return null;

        PassportDTO dto = new PassportDTO();
        dto.setId(passport.getId());
        dto.setPassportNumber(passport.getPassportNumber());
        dto.setCountry(passport.getCountry());

        // Set personId instead of nested object
        if (passport.getPerson() != null) {
            dto.setPersonId(passport.getPerson().getId());
        }

        return dto;
    }

    // DTO -> ENTITY
    public static Passport toEntity(PassportDTO dto) {
        if (dto == null) return null;

        Passport passport = new Passport();
        passport.setId(dto.getId());
        passport.setPassportNumber(dto.getPassportNumber());
        passport.setCountry(dto.getCountry());

        // Attach Person using personId
        if (dto.getPersonId() != null) {
            Person person = new Person();
            person.setId(dto.getPersonId());
            passport.setPerson(person);
        }

        return passport;
    }
}
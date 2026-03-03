package com.example.CRUD.Operations.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.Set;
@Data
public class PersonDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String address;
    private String location;
    private Set<Long> skillIds;
}
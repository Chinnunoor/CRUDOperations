package com.example.CRUD.Operations.dto;

import lombok.Data;

@Data
public class PassportDTO {

    private Long id;
    private String passportNumber;
    private String country;

    private Long personId;

}
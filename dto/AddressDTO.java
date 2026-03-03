package com.example.CRUD.Operations.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private Long id;
    private String line1;
    private String city;
    private String state;
    private String zip;

    private Long personId; // only reference, not full object
}
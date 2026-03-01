package com.example.CRUD.Operations.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "passport")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Passport number is required")
    private String passportNumber;
    @NotBlank(message = "Country is required")
    private String country;

    @NotNull(message = "Person reference is required")
    @JsonBackReference
    @OneToOne //one person have one passport
    @JoinColumn(name = "person_id", nullable = false, unique = true)//FK //we are creating new column in passport caled person-id
    private Person person;
}

//one to one
//one to many
//many to many
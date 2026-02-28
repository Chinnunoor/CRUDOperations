package com.example.CRUD.Operations.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "passport")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passportNumber;
    private String country;

    @OneToOne //one person have one passport
    @JoinColumn(name = "person_id", nullable = false, unique = true)//FK //we are creating new column in passport caled person-id
    private Person person;
}

//one to one
//one to many
//many to many
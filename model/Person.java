package com.example.CRUD.Operations.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.Set;
import java.time.LocalDate;
@Data //generates getters/setters etc automatically.
@Entity //JPA Entity → means it maps to a database table.
@Table(name = "persons")
public class Person {

    @Id//primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB auto generates ID
    private Long id; //pk

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String address;
    private String location;
    // One Person → One Passport
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Passport passport;

    // One Person → Many Addresses
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL) //also save new Addresses inside addresses
    private List<Address> addresses;

    // Many Persons ↔ Many Skills
    @ManyToMany
    @JoinTable(
            name = "person_skill",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills;


}
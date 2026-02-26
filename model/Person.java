package com.example.CRUD.Operations.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.Set;
import java.time.LocalDate;
@Data
@Entity
@Table(name = "persons")
public class Person {

    @Id//primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String address;
    private String location;
    // One Person → One Passport
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Passport passport;

    // One Person → Many Addresses
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
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
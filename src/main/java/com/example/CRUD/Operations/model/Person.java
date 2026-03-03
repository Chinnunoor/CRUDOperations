package com.example.CRUD.Operations.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.time.LocalDate;
//@Data
@Getter
@Setter
@Entity //JPA Entity → means it maps to a database table.
@Table(name = "persons")
public class Person {

    @Id//primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB auto generates ID
    private Long id; //pk
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;
    @Size(min = 10, max = 10, message = "Phone must be 10 digits")
    private String phoneNumber;
    private String address;
    private String location;
    // One Person → One Passport
    @JsonManagedReference
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Passport passport;

    // One Person → Many Addresses
    @JsonManagedReference
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL) //also save new Addresses inside addresses
    private List<Address> addresses;

    // Many Persons ↔ Many Skills
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "person_skill",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills;


}
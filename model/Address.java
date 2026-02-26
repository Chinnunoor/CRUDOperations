package com.example.CRUD.Operations.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@Data //getter qnd setter will create by lombok dependency
@NoArgsConstructor //it creates a no arguments constructor
@AllArgsConstructor //it creates a all arguments constructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String line1;
    private String city;
    private String state;
    private String zip;

    @ManyToOne
    @JoinColumn(name = "person_id") //it will craete a new column in db called person id, when you put @joincolumn that menas it is foreign key
    private Person person;

    //all args
//    public Address(Long id, String line1, String city, String state, String zip, Person person) {
//        this.id = id;
//        this.line1 = line1;
//        this.city = city;
//        this.state = state;
//        this.zip = zip;
//        this.person = person;
//    }
//
     /// no args
//    public Address() {
//
//    }
}

//one
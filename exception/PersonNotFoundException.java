package com.example.CRUD.Operations.exception;

public class PersonNotFoundException extends RuntimeException //means:This is an “unchecked” exception, so you don’t need to write throws everywhere
{

    public PersonNotFoundException(String message) //Constructor (a method that runs when you create the exception)
    {
        super(message);
    }
}
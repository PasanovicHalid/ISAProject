package com.example.BloodBank.exceptions;

public class EntityDoesntExistException extends Exception {
    public EntityDoesntExistException() {
        super("Entity doesn't exist");
    }

    public EntityDoesntExistException(Long id) {
        super("Entity with id: " + id + " doesn't exist");
    }
}
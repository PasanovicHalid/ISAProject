package com.example.BloodBank.excpetions;

public class EntityDoesntExistException extends Exception {
    public EntityDoesntExistException() {
        super("Entity doesn't exist");
    }

    public EntityDoesntExistException(int id) {
        super("Entity with id: " + id + " doesn't exist");
    }
}

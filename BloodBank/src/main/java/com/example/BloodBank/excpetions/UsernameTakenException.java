package com.example.BloodBank.excpetions;

public class UsernameTakenException extends Exception {
    public  UsernameTakenException() {
        super("Username is taken!");
    }
    public UsernameTakenException(String username) {
        super("Username is taken: " + username);
    }
}

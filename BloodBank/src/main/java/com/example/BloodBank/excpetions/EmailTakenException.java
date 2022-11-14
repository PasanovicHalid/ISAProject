package com.example.BloodBank.excpetions;

public class EmailTakenException extends Exception{
    public EmailTakenException(){
        super("Email is taken");
    }
    public EmailTakenException(String email) {
        super("Email is taken: " + email);
    }
}

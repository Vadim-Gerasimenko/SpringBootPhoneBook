package ru.academits.gerasimenko.springbootphonebook.exception;

public class ContactNotFoundException extends ContactProcessingException {
    public ContactNotFoundException(String message) {
        super(message);
    }
}
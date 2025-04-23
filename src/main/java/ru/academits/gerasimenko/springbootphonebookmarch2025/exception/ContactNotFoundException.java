package ru.academits.gerasimenko.springbootphonebookmarch2025.exception;

public class ContactNotFoundException extends ContactProcessingException {
    public ContactNotFoundException(String message) {
        super(message);
    }
}
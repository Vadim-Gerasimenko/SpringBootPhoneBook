package ru.academits.gerasimenko.springbootphonebookmarch2025.exception;

public class ExistingContactNumberException extends ContactProcessingException {
    public ExistingContactNumberException(String message) {
        super(message);
    }
}
package ru.academits.gerasimenko.springbootphonebook.exception;

public class ExistingContactNumberException extends ContactProcessingException {
    public ExistingContactNumberException(String message) {
        super(message);
    }
}
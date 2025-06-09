package ru.academits.gerasimenko.springbootphonebook.exception;

public class IncorrectContactDataException extends ContactProcessingException {
    public IncorrectContactDataException(String message) {
        super(message);
    }
}
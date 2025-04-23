package ru.academits.gerasimenko.springbootphonebookmarch2025.exception;

public class IncorrectContactDataException extends ContactProcessingException {
    public IncorrectContactDataException(String message) {
        super(message);
    }
}
package ru.academits.gerasimenko.springbootphonebook.exception;

public class ContactProcessingException extends RuntimeException {
  public ContactProcessingException(String message) {
    super(message);
  }
}
package ru.academits.gerasimenko.springbootphonebookmarch2025.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.academits.gerasimenko.springbootphonebookmarch2025.data.Response;
import ru.academits.gerasimenko.springbootphonebookmarch2025.exception.ContactProcessingException;

@ControllerAdvice
public class ContactProcessingExceptionHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response catchContactProcessingException(ContactProcessingException e) {
        return new Response(false, e.getMessage());
    }
}
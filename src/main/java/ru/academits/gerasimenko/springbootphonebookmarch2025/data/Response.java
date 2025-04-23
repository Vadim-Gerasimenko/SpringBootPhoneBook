package ru.academits.gerasimenko.springbootphonebookmarch2025.data;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Response {
    private boolean success;
    private String message;
}
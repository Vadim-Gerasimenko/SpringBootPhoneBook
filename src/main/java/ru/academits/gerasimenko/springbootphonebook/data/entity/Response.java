package ru.academits.gerasimenko.springbootphonebook.data.entity;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Response {
    private boolean success;
    private String message;
}
package ru.academits.gerasimenko.springbootphonebook.service;

import ru.academits.gerasimenko.springbootphonebook.data.dto.Contact;

import java.util.List;

public interface PhoneBookService {
    List<Contact> getContacts(String term);

    void addContact(Contact contact);

    void updateContact(Contact contact);

    void deleteContact(int id);
}
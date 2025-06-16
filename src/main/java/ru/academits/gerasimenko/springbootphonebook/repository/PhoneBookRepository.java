package ru.academits.gerasimenko.springbootphonebook.repository;

import ru.academits.gerasimenko.springbootphonebook.dto.Contact;

import java.util.List;

public interface PhoneBookRepository {
    List<Contact> getContacts(String term);

    void addContact(Contact contact);

    void updateContact(Contact contact);

    void deleteContact(int id);
}
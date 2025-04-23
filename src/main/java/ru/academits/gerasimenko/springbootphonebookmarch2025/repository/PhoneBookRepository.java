package ru.academits.gerasimenko.springbootphonebookmarch2025.repository;

import ru.academits.gerasimenko.springbootphonebookmarch2025.data.Contact;

import java.util.List;

public interface PhoneBookRepository {
    List<Contact> getContacts(String term);

    void addContact(Contact contact);

    void updateContact(Contact contact);

    void deleteContact(int id);
}
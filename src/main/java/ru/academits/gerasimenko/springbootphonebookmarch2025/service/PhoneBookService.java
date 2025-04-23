package ru.academits.gerasimenko.springbootphonebookmarch2025.service;

import ru.academits.gerasimenko.springbootphonebookmarch2025.data.Contact;

import java.util.List;

public interface PhoneBookService {
    List<Contact> getContacts(String term);

    void addContact(Contact contact);

    void updateContact(Contact contact);

    void deleteContact(int id);
}
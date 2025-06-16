package ru.academits.gerasimenko.springbootphonebook.data;

import ru.academits.gerasimenko.springbootphonebook.exception.ContactNotFoundException;
import ru.academits.gerasimenko.springbootphonebook.exception.ContactProcessingException;
import ru.academits.gerasimenko.springbootphonebook.exception.ExistingContactNumberException;
import ru.academits.gerasimenko.springbootphonebook.exception.IncorrectContactDataException;
import ru.academits.gerasimenko.springbootphonebook.repository.PhoneBookRepository;

public class ContactProcessor {
    private ContactProcessor() {
    }

    public static Contact processContact(Contact contact) {
        return new Contact(
                contact.getId(),
                TextUtilities.getEscapedHtmlText(contact.getName()),
                TextUtilities.getEscapedHtmlText(contact.getSurname()),
                TextUtilities.getEscapedHtmlText(contact.getPhone())
        );
    }

    public static boolean isCorrectContact(Contact contact) {
        if (contact == null) {
            throw new ContactProcessingException("Contact is null");
        }

        if (TextUtilities.isIncorrectField(contact.getName())) {
            throw new IncorrectContactDataException("Contact name is incorrect");
        }

        if (TextUtilities.isIncorrectField(contact.getSurname())) {
            throw new IncorrectContactDataException("Contact surname is incorrect");
        }

        if (TextUtilities.isIncorrectField(contact.getPhone())) {
            throw new IncorrectContactDataException("Contact phone is incorrect");
        }

        return true;
    }

    public static boolean isNotExistingContact(PhoneBookRepository phoneBook, Contact contact) {
        if (phoneBook.getContacts("").stream()
                .anyMatch(c -> c.getPhone().equals(contact.getPhone()))
        ) {
            throw new ExistingContactNumberException("Phone number '" + contact.getPhone() + "' already exists");
        }

        return true;
    }

    public static boolean isNotExistingContactOrSame(PhoneBookRepository phoneBook, Contact contact) {
        if (phoneBook.getContacts("").stream()
                .anyMatch(c -> c.getId() != contact.getId() && c.getPhone().equals(contact.getPhone()))
        ) {
            throw new ExistingContactNumberException("Phone number '" + contact.getPhone() + "' already exists");
        }

        return true;
    }

    public static boolean isExistingContactById(PhoneBookRepository phoneBook, int id) {
        if (phoneBook.getContacts("").stream().noneMatch(c -> c.getId() == id)
        ) {
            throw new ContactNotFoundException("Contact with id = " + id + " not found");
        }

        return true;
    }
}
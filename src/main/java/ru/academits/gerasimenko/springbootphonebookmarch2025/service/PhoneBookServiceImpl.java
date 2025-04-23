package ru.academits.gerasimenko.springbootphonebookmarch2025.service;

import org.springframework.stereotype.Service;
import ru.academits.gerasimenko.springbootphonebookmarch2025.data.Contact;
import ru.academits.gerasimenko.springbootphonebookmarch2025.data.ContactProcessor;
import ru.academits.gerasimenko.springbootphonebookmarch2025.repository.PhoneBookRepository;

import java.util.List;

@Service
public class PhoneBookServiceImpl implements PhoneBookService {
    private final PhoneBookRepository phoneBookRepository;

    public PhoneBookServiceImpl(PhoneBookRepository phoneBookRepository) {
        this.phoneBookRepository = phoneBookRepository;
    }

    @Override
    public List<Contact> getContacts(String term) {
        return phoneBookRepository.getContacts(term);
    }

    @Override
    public void addContact(Contact contact) {
        Contact newContact = ContactProcessor.processContact(contact);

        if (ContactProcessor.isCorrectContact(newContact)
                & ContactProcessor.isNotExistingContact(phoneBookRepository, newContact)
        ) {
            phoneBookRepository.addContact(newContact);
        }
    }

    @Override
    public void updateContact(Contact contact) {
        Contact newContact = ContactProcessor.processContact(contact);

        if (ContactProcessor.isCorrectContact(newContact)
                & ContactProcessor.isExistingContactById(phoneBookRepository, newContact.getId())
                & ContactProcessor.isNotExistingContactOrSame(phoneBookRepository, newContact)
        ) {
            phoneBookRepository.updateContact(contact);
        }
    }

    @Override
    public void deleteContact(int id) {
        if (ContactProcessor.isExistingContactById(phoneBookRepository, id)) {
            phoneBookRepository.deleteContact(id);
        }
    }
}
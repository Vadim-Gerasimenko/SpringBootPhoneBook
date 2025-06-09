package ru.academits.gerasimenko.springbootphonebook.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.academits.gerasimenko.springbootphonebook.data.Contact;
import ru.academits.gerasimenko.springbootphonebook.data.ContactProcessor;
import ru.academits.gerasimenko.springbootphonebook.repository.PhoneBookRepository;

import java.util.List;
import java.util.Random;

@Service
@EnableScheduling
@Slf4j
public class PhoneBookServiceImpl implements PhoneBookService {
    private final PhoneBookRepository phoneBookRepository;
    private final Random randomIndexGenerator = new Random();

    public PhoneBookServiceImpl(PhoneBookRepository phoneBookRepository) {
        this.phoneBookRepository = phoneBookRepository;
    }

    @Override
    public List<Contact> getContacts(String term) {
        log.info("A contact list containing the term \"{}\" was returned.", term);
        return phoneBookRepository.getContacts(term);
    }

    @Override
    public void addContact(Contact contact) {
        Contact newContact = ContactProcessor.processContact(contact);
        log.info("Trying to add new contact");

        if (ContactProcessor.isCorrectContact(newContact)
                & ContactProcessor.isNotExistingContact(phoneBookRepository, newContact)
        ) {
            phoneBookRepository.addContact(newContact);
            log.info("New contact added successfully");
        } else {
            log.warn("Failed to create contact");
        }
    }

    @Override
    public void updateContact(Contact contact) {
        Contact newContact = ContactProcessor.processContact(contact);
        log.info("Trying to update contact with id = {}", newContact.getId());

        if (ContactProcessor.isCorrectContact(newContact)
                & ContactProcessor.isExistingContactById(phoneBookRepository, newContact.getId())
                & ContactProcessor.isNotExistingContactOrSame(phoneBookRepository, newContact)
        ) {
            phoneBookRepository.updateContact(contact);

            log.info("Contact with id = {} updated successfully", newContact.getId());
        } else {
            log.warn("Failed to update contact with id = {}", newContact.getId());
        }
    }

    @Override
    public void deleteContact(int id) {
        log.info("Trying to delete contact with id = {}", id);

        if (ContactProcessor.isExistingContactById(phoneBookRepository, id)) {
            phoneBookRepository.deleteContact(id);

            log.info("Contact with id = {} deleted successfully", id);
        } else {
            log.warn("Failed to delete contact with id = {}", id);
        }
    }

    @Scheduled(fixedRate = 10000)
    public void deleteRandomContact() {
        log.info("Launched scheduled task that deletes random contacts every 10 seconds");

        List<Contact> contacts = phoneBookRepository.getContacts("");
        int contactsAmount = contacts.size();

        if (contactsAmount == 0) {
            log.warn("Scheduled task not completed: contacts missing");
            return;
        }

        Contact deletedContact = contacts.get(randomIndexGenerator.nextInt(contactsAmount));
        log.info("Random contact id for deletion defined: id = {}", deletedContact.getId());

        deleteContact(deletedContact.getId());
        log.info("Scheduled task completed successfully");
    }
}
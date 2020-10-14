package com.poddubchak.education.docker.service;

import com.poddubchak.education.docker.model.Contact;
import com.poddubchak.education.docker.model.Status;
import com.poddubchak.education.docker.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

public class ContactService {
    private ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact createContact(Contact contact){
        contact.setStatus(Status.NEW);
        contact.setCreated(LocalDateTime.now());
        contact.setModified(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact confirmContact (Contact contact){
        contact.setStatus(Status.ACTIVE);
        contact.setModified(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact modifyContact (Contact contact){
        contact.setModified(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public void deleteContact (Long contactId){
        Contact deletedContact =contactRepository.findById(contactId).orElseThrow(()->new NoSuchElementException());
        deletedContact.setStatus(Status.DELETED);
        deletedContact.setModified(LocalDateTime.now());
        contactRepository.save(deletedContact);
    }
}

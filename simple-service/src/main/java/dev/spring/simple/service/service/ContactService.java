package dev.spring.simple.service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.spring.simple.service.persistance.entity.ContactEntity;
import dev.spring.simple.service.persistance.repository.ContactRepository;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContactService {
    public final ContactRepository repository;

    public List<ContactEntity> getContacts() {
        List<ContactEntity> contacts = repository.findAll();
        log.info("Contacts found: {}!", contacts.size());
        return contacts;
    }

    public ContactEntity getContact(Long contactId) {
        return repository.findById(contactId).orElse(null);
    }

}
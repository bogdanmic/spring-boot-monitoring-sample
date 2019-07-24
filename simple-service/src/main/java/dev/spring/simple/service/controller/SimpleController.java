package dev.spring.simple.service.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.spring.simple.service.aspect.LogPerformance;
import dev.spring.simple.service.persistance.entity.ContactEntity;
import dev.spring.simple.service.service.ContactService;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SimpleController {

    private final ContactService contactService;

    @LogPerformance
    @GetMapping(value = "/api/v1/contacts")
    public List<ContactEntity> getContacts() {
        return contactService.getContacts();
    }

    @LogPerformance
    @GetMapping(value = "/api/v1/contacts/{contactId}")
    public ContactEntity getContact(@PathVariable(name = "contactId") Long contactId) {
        return contactService.getContact(contactId);
    }
}
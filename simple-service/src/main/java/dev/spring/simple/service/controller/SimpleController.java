package dev.spring.simple.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SimpleController {
    @GetMapping(value = "/api/v1/contacts")
    public String getContacts() {
        return String.format("Get contacts");
    }

    @GetMapping(value = "/api/v1/contacts/{contactId}")
    public String getContact(@PathVariable(name = "contactId") Long contactId) {
        return String.format("Get contact \'%s\'.", contactId);
    }
}
package com.quizApp.quizApplication.controller;

import com.quizApp.quizApplication.entity.Contact;
import com.quizApp.quizApplication.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping(value = "/save")
    public ResponseEntity<Contact> saveContact(@RequestBody @Valid Contact contact) {
        Contact contact1 = contactService.saveContact(contact);
        return ResponseEntity.ok(contact1);
    }
}

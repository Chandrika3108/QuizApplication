package com.quizApp.quizApplication.service.impl;

import com.quizApp.quizApplication.dao.ContactDAO;
import com.quizApp.quizApplication.entity.Contact;
import com.quizApp.quizApplication.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactDAO contactDAO;

    @Override
    public Contact saveContact(Contact contact) {
        return contactDAO.save(contact);
    }
}

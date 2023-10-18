package com.quizApp.quizApplication.dao;

import com.quizApp.quizApplication.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDAO extends JpaRepository<Contact, Integer> {
}

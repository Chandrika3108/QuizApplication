package com.quizApp.quizApplication.dao;

import com.quizApp.quizApplication.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends CrudRepository<User, Long> {

    List<User> findByEmail(String email);

}
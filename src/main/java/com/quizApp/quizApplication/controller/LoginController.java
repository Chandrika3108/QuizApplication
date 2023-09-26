package com.quizApp.quizApplication.controller;

import com.quizApp.quizApplication.dao.AuthorityDAO;
import com.quizApp.quizApplication.dao.UserDAO;
import com.quizApp.quizApplication.entity.Authority;
import com.quizApp.quizApplication.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDAO userDAO;


    @Autowired
    AuthorityDAO authorityDAO;



    @GetMapping("/login")
    public User getUserDetailsAfterLogin(Authentication authentication) {
        List<User> users = userDAO.findByEmail(authentication.getName());
        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            return null;
        }

    }

}

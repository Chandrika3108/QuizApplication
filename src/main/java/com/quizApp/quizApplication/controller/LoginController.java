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

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDAO userDAO;


    @Autowired
    AuthorityDAO authorityDAO;

    @PostMapping("/user/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        User saved = null;
        ResponseEntity<String> response = null;
        try {
            //hashing password
            List<User> users = userDAO.findByEmail(user.getEmail());
            if (!users.isEmpty()) {
                throw new Exception("User " + user.getEmail() + " already exists");
            }
            user.setPwd(passwordEncoder.encode(user.getPwd()));
            user.setCreateDt(new Date(System.currentTimeMillis()));
            user.setAuthorities(null);
            saved = userDAO.save(user);
            Authority authority = new Authority();
            authority.setName("ROLE_USER");
            authority.setUser(saved);
            authorityDAO.save(authority);
            response = ResponseEntity.status(HttpStatus.CREATED).body("User is successfully registered");
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception occured due to " + e.getMessage());
        }
        return response;
    }

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

package com.quizApp.quizApplication.controller;


import com.quizApp.quizApplication.dao.AuthorityDAO;
import com.quizApp.quizApplication.dao.UserDAO;
import com.quizApp.quizApplication.entity.Authority;
import com.quizApp.quizApplication.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTests {

    @Mock
    UserDAO userDAO;
    @Mock
    AuthorityDAO authorityDAO;


    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    LoginController loginController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void registerUserSuccess() {
        User user = new User();
        user.setUsername("chandrika");
        user.setPwd("12345");
        user.setEmail("test@example.com");
        user.setMobileNumber("1234567894");
        Mockito.when(userDAO.findByEmail(user.getEmail())).thenReturn(new ArrayList<>());
        Mockito.when(userDAO.save(user)).thenReturn(user);
        Authority authority = new Authority();
        authority.setName("ROLE_USER");
        authority.setUser(user);
        Mockito.when(passwordEncoder.encode(user.getPwd())).thenReturn("$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2");
        Mockito.lenient().when(authorityDAO.save(authority)).thenReturn(authority);
        ResponseEntity<String> response = loginController.registerUser(user);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        Assert.assertEquals("User is successfully registered", response.getBody());
    }

    @Test
    public void registerUserAlreadyExists() {
        User user = new User();
        user.setUsername("chandrika");
        user.setPwd("12345");
        user.setEmail("test@example.com");
        user.setMobileNumber("1234567894");
        Mockito.when(userDAO.findByEmail(user.getEmail())).thenReturn(List.of(user));
        ResponseEntity<String> response = loginController.registerUser(user);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @Test
    public void getUserDetailsAfterLoginSuccess() {
        User user = new User();
        user.setUsername("chandrika");
        user.setPwd("12345");
        user.setEmail("test@example.com");
        user.setMobileNumber("1234567894");
        Mockito.when(userDAO.findByEmail(user.getEmail())).thenReturn(List.of(user));
        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPwd());
        User response = loginController.getUserDetailsAfterLogin(authentication);
        Assert.assertEquals(user.getEmail(), response.getEmail());

    }

    @Test
    public void getUserDetailsAfterLoginFailure() {
        User user = new User();
        user.setUsername("chandrika");
        user.setPwd("12345");
        user.setEmail("test@example.com");
        user.setMobileNumber("1234567894");
        Mockito.when(userDAO.findByEmail(user.getEmail())).thenReturn(new ArrayList<>());
        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPwd());
        User response = loginController.getUserDetailsAfterLogin(authentication);
        Assert.assertNull(response);

    }
}

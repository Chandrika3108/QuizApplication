package com.quizApp.quizApplication.config;

import com.quizApp.quizApplication.dao.UserDAO;
import com.quizApp.quizApplication.entity.Authority;
import com.quizApp.quizApplication.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class QuizAppAuthenticationProviderTests {
    @InjectMocks
    QuizAppAuthenticationProvider quizAppAuthenticationProvider;
    @Mock
    UserDAO userDAO;

    @Mock
    PasswordEncoder passwordEncoder;


    @Test
    public void authenticateTestsValidAuthentication() {
        User user = new User();
        user.setUsername("chandrika");
        user.setEmail("test@test.com");
        user.setPwd("hashedpassword");
        Set<Authority> authorities = new HashSet<>();
        Authority authority = new Authority();
        authority.setId(1l);
        authority.setName("ROLE_ADMIN");
        user.setAuthorities(authorities);
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(), "12345");
        Mockito.when(userDAO.findByEmail((String) authentication.getPrincipal())).thenReturn(List.of(user));
        Mockito.when(passwordEncoder.matches(authentication.getCredentials().toString(), user.getPwd())).thenReturn(true);
        Authentication response = quizAppAuthenticationProvider.authenticate(authentication);
        Assert.assertEquals(response.getPrincipal(), authentication.getPrincipal());

    }

    @Test(expected = BadCredentialsException.class)
    public void authenticateTestsInvalidUser() {
        User user = new User();
        user.setUsername("chandrika");
        user.setEmail("test@test.com");
        user.setPwd("hashedpassword");
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(), "12345");
        Mockito.when(userDAO.findByEmail((String) authentication.getPrincipal())).thenReturn(new ArrayList<>());
        quizAppAuthenticationProvider.authenticate(authentication);


    }

    @Test(expected = BadCredentialsException.class)
    public void authenticateTestsWrongPassword() {
        User user = new User();
        user.setUsername("chandrika");
        user.setEmail("test@test.com");
        user.setPwd("hashedpassword");
        Set<Authority> authorities = new HashSet<>();
        Authority authority = new Authority();
        authority.setId(1l);
        authority.setName("ROLE_ADMIN");
        user.setAuthorities(authorities);
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(), "12345");
        Mockito.when(userDAO.findByEmail((String) authentication.getPrincipal())).thenReturn(List.of(user));
        Mockito.when(passwordEncoder.matches(authentication.getCredentials().toString(), user.getPwd())).thenReturn(false);
        quizAppAuthenticationProvider.authenticate(authentication);
    }

    @Test
    public void supportsTest() {
        Class<UsernamePasswordAuthenticationToken> authenticationClass = UsernamePasswordAuthenticationToken.class;
        Assert.assertTrue(quizAppAuthenticationProvider.supports(authenticationClass));
    }
}

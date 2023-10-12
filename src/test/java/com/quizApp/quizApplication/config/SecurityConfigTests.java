package com.quizApp.quizApplication.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RunWith(MockitoJUnitRunner.class)
public class SecurityConfigTests {

    @InjectMocks
    SecurityConfig securityConfig;

    @Mock
    HttpSecurity httpSecurity;

    @Test(expected = NullPointerException.class)
    public void defaultSecurityFilterChainTest() throws Exception {
        Mockito.when(httpSecurity.sessionManagement(Mockito.any())).thenReturn(null);
        securityConfig.defaultSecurityFilterChain(httpSecurity);
    }

    @Test
    public void passwordEncoderTest() {
        PasswordEncoder passwordEncoder = securityConfig.passwordEncoder();
        Assert.assertEquals(BCryptPasswordEncoder.class, passwordEncoder.getClass());
    }
}

package com.quizApp.quizApplication.config;

import com.quizApp.quizApplication.dao.UserDAO;
import com.quizApp.quizApplication.entity.Authority;
import com.quizApp.quizApplication.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class QuizAppAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<User> customers = userDAO.findByEmail(username);
        if (customers.isEmpty()) {
            throw new BadCredentialsException("User not found");
        } else {
            if (passwordEncoder.matches(password, customers.get(0).getPwd())) {
                return new UsernamePasswordAuthenticationToken(username, password, getGrantedAuthorities(customers.get(0).getAuthorities()));
            } else {
                throw new BadCredentialsException("Invalid Credentials");
            }
        }
    }

    private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
        return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getName())).collect(Collectors.toList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

package com.codecool.apigateway.security;


import com.codecool.apigateway.modell.UserCredentials;
import com.codecool.apigateway.modell.UserRole;
import com.codecool.apigateway.service.UserServiceCaller;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);

    private UserServiceCaller userServiceCaller;

    public CustomUserDetailsService(UserServiceCaller userServiceCaller) {
        this.userServiceCaller = userServiceCaller;
    }

    /**
     * Loads the user from the DB and converts it to Spring Security's internal User object
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials user = userServiceCaller.getUserCredentialByUserName(username);
        LOGGER.info(user.toString() + " " + "found");
        return new User(user.getUsername(), user.getPassword(),
                user
                        .getRoles()
                        .stream()
                        .map(UserRole::getRole)// we mapped the userRole to its String value because SimpleGrantedAuthority eats String.
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()));
    }
}


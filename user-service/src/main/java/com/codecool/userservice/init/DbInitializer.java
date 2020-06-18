package com.codecool.userservice.init;

import com.codecool.userservice.entity.User;
import com.codecool.userservice.entity.UserRole;
import com.codecool.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer {

    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();


    @Autowired
    private UserRepository userRepository;

    public void intializeDatabase() {
        User customer = User.builder()
                .username("customer")
                .password(passwordEncoder.encode("sas"))
                .role(UserRole.ROLE_CUSTOMER)
                .build();
        userRepository.save(customer);
        User cook = User.builder()
                .username("cook")
                .password(passwordEncoder.encode("sas"))
                .role(UserRole.ROLE_COOK)
                .build();
        userRepository.save(cook);
        User manager = User.builder()
                .username("manager")
                .password(passwordEncoder.encode("sas"))
                .role(UserRole.ROLE_MANAGER)
                .build();
        userRepository.save(manager);
        User deliveryGuy = User.builder()
                .username("deliveryGuy")
                .password(passwordEncoder.encode("sas"))
                .role(UserRole.ROLE_DELIVERYGUY)
                .build();
        userRepository.save(deliveryGuy);


    }

}

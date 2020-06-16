package com.codecool.userservice.init;

import com.codecool.userservice.entity.User;
import com.codecool.userservice.modell.UserRole;
import com.codecool.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer {
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public DbInitializer(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

    @Autowired
    private UserRepository userRepository;
    public void intializeDatabase() {
        User customer = User.builder()
                .username("customer")
                .password("a")
                .role(UserRole.CUSTOMER)
                .build();
        userRepository.save(customer);
        User cook = User.builder()
                .username("cook")
                .password("a")
                .role(UserRole.COOK)
                .build();
        userRepository.save(cook);
        User manager = User.builder()
                .username("manager")
                .password("a")
                .role(UserRole.MANAGER)
                .build();
        userRepository.save(manager);
        User deliveryGuy = User.builder()
                .username("deliveryGuy")
                .password("a")
                .role(UserRole.DELIVERYGUY)
                .build();
        userRepository.save(deliveryGuy);


    }

}

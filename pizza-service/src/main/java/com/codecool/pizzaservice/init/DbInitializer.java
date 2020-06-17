package com.codecool.pizzaservice.init;

import com.codecool.pizzaservice.entity.Pizza;
import com.codecool.pizzaservice.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer {

    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();


    @Autowired
    private PizzaRepository pizzaRepository;

    public void intializeDatabase() {
        for (int i = 1; i < 21; i++) {
            String pizzaName = "pizza_" + i;
            Pizza pizzaa = Pizza.builder()
                    .name(pizzaName)
                    .description("tastes reeel goooood")
                    .price(3000)
                    .build();
            pizzaRepository.save(pizzaa);
        }

        Pizza pizza = Pizza.builder()
                .name("Testpizza")
                .description("tastes reeel goooood")
                .price(6000)
                .build();

        Pizza pizza2 = Pizza.builder()
                .name("Testpizza2")
                .description("tastes good ")
                .price(6000)
                .build();
        Pizza pizza3 = Pizza.builder()
                .name("Testpizza3")
                .description("great pizza ")
                .price(8000)
                .build();
        Pizza pizza4 = Pizza.builder()
                .name("4 seasons")
                .description("Tasty")
                .price(47000)
                .build();
        pizzaRepository.save(pizza);
        pizzaRepository.save(pizza2);
        pizzaRepository.save(pizza3);
        pizzaRepository.save(pizza4);

    }

}

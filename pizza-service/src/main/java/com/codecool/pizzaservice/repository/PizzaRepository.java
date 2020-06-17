package com.codecool.pizzaservice.repository;

import com.codecool.pizzaservice.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    Pizza getPizzaById(Long Id);

    @Query(value = "SELECT * FROM Pizza LIMIT (?1*10-10),10", nativeQuery = true)
    List<Pizza> getPaginatedPizzas(Integer page);
}

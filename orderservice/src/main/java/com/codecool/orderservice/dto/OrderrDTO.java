package com.codecool.orderservice.dto;

import com.codecool.orderservice.entity.OrderStatus;

import com.codecool.orderservice.modell.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderrDTO {
    private Long id;
    private OrderStatus orderStatus;
    private User customer;
    private User cook;
    private User deliveryGuy;
    List<PizzaQuantityDTO> incomingOrderedPizzas;

    public OrderrDTO(List<PizzaQuantityDTO> orderedPizzas) {
        this.incomingOrderedPizzas = orderedPizzas;
    }

    public OrderrDTO(Long id, OrderStatus orderStatus) {
        this.id = id;
        this.orderStatus = orderStatus;

    }


}

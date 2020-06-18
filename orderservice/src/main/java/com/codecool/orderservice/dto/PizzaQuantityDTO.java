package com.codecool.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PizzaQuantityDTO {
    private Long id;
    private String name;
    private String description;
    private int quantity;


}

package com.codecool.userservice.modell;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Pizza {

    private Long id;


    private String name;

    private String description;


    private int price;
    public Pizza(Long id) {
        this.id = id;
    }


}

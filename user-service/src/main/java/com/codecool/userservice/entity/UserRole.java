package com.codecool.userservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public enum UserRole {
    ROLE_COOK("ROLE_COOK"),
    ROLE_CUSTOMER("ROLE_CUSTOMER"),
    ROLE_MANAGER("ROLE_MANAGER"),
    ROLE_DELIVERYGUY("ROLE_DELIVERYGUY");

    private String role;
    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

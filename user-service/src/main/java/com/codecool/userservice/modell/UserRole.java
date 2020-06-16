package com.codecool.userservice.modell;

import lombok.Data;


public enum UserRole {
    COOK("COOK"),
    CUSTOMER("CUSTOMER"),
    MANAGER("MANAGER"),
    DELIVERYGUY("DELIVERYGUY");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

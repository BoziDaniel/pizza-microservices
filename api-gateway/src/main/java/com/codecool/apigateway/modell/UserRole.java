package com.codecool.apigateway.modell;



public enum UserRole {
    COOK("COOK"),
    CUSTOMER("CUSTOMER"),
    ROLE_MANAGER("ROLE_MANAGER"),
    DELIVERYGUY("DELIVERYGUY");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

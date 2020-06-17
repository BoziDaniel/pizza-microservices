package com.codecool.userservice.modell;




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

package com.caua.api_marketplace.Models.User;

public enum UserRole {

    UserAdmin("Admin"),
    UserClient("Client"),
    UserProducer("Producer");

    private String role;

    UserRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}

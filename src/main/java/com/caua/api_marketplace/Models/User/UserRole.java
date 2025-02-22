package com.caua.api_marketplace.Models.User;

public enum UserRole {

    UserAdmin("ROLE_ADMIN"),
    UserClient("ROLE_CLIENT"),
    UserProducer("ROLE_PRODUCER");

    private String role;

    UserRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}

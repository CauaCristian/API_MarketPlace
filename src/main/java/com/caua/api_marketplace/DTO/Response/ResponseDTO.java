package com.caua.api_marketplace.DTO.Response;

import org.springframework.security.core.userdetails.UserDetails;

public class ResponseDTO<Type> {
    private String message;
    private boolean error;
    private String token;
    private Type data;

    public ResponseDTO(String message, boolean error, String token, Type data) {
        this.message = message;
        this.error = error;
        this.token = token;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Type getData() {
        return data;
    }

    public void setData(Type data) {
        this.data = data;
    }
}

package com.caua.api_marketplace.DTO.Auth;

import com.caua.api_marketplace.Models.User.UserModel;
import org.springframework.security.core.userdetails.UserDetails;

public class ResponseLoginDTO {

    private String message;
    private boolean error;
    private String token;
    private UserDetails data;

    public ResponseLoginDTO(String message, boolean error, String token, UserDetails data) {
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

    public UserDetails getData() {
        return data;
    }

    public void setData(UserDetails data) {
        this.data = data;
    }
}

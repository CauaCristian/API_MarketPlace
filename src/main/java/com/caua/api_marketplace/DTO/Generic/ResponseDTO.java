package com.caua.api_marketplace.DTO.Generic;

public class ResponseDTO<Type> {
    private String message;
    private boolean error;
    private Type data;
    public ResponseDTO(String message, boolean error, Type data) {
        this.message = message;
        this.error = error;
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

    public Type getData() {
        return data;
    }

    public void setData(Type data) {
        this.data = data;
    }
}

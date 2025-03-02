package com.caua.api_marketplace.DTO.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class UserClientDTO {

    private Long id;

    private String username;

    private String email;

    private String phone;

    private String address;

    private String cpf;

    private LocalDate dateOfBirth;

    @JsonProperty("image")
    private byte[] image;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] imagem) {
        this.image = imagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

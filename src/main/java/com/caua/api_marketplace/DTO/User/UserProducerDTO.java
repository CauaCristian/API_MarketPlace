package com.caua.api_marketplace.DTO.User;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class UserProducerDTO {

    private Long id;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String address;

    private String cpf;

    private LocalDate dateOfBirth;

    private String surname;

    private String farm;

    private String rating;

    private String numRating;
}

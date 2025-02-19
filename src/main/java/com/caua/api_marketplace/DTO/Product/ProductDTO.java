package com.caua.api_marketplace.DTO.Product;

import com.caua.api_marketplace.Models.User.UserProducerModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ProductDTO {
    private Long id;

    private String name;

    private double price;

    private int quantity;

    private String category;

    private Long producerId;
}

package com.caua.api_marketplace.Models.Product;

import com.caua.api_marketplace.Models.User.UserProducerModel;
import jakarta.persistence.*;

@Entity
@Table(name = "product")

public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private String category;
    @ManyToOne
    @JoinColumn(name = "producer_id", nullable = false)
    private UserProducerModel producer;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;

    public ProductModel(long id, String name, double price, int quantity, String category, UserProducerModel producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.producer = producer;
    }

    public ProductModel() {
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public UserProducerModel getProducer() {
        return producer;
    }

    public void setProducer(UserProducerModel producer) {
        this.producer = producer;
    }

    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }

}

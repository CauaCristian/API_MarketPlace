package com.caua.api_marketplace.Models.Relation;

import com.caua.api_marketplace.Models.Product.ProductModel;
import com.caua.api_marketplace.Models.User.UserClientModel;
import com.caua.api_marketplace.Models.User.UserProducerModel;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservation")

public class ReservationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private UserClientModel client;
    @ManyToOne
    @JoinColumn(name = "producer_id", nullable = false)
    private UserProducerModel producer;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductModel product;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private LocalDate dateReservation;
    @Column(nullable = false)
    private String status;

    public ReservationModel() {

    }
    public ReservationModel(long id, UserClientModel client, UserProducerModel producer, ProductModel product, int quantity, double price, LocalDate dateReservation, String status) {
        this.id = id;
        this.client = client;
        this.producer = producer;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.dateReservation = dateReservation;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserClientModel getClient() {
        return client;
    }

    public void setClient(UserClientModel client) {
        this.client = client;
    }

    public UserProducerModel getProducer() {
        return producer;
    }

    public void setProducer(UserProducerModel producer) {
        this.producer = producer;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

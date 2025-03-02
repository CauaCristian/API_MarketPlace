package com.caua.api_marketplace.Models.User;
import com.caua.api_marketplace.Models.Product.ProductModel;
import com.caua.api_marketplace.Models.Relation.ReservationModel;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "producer")
@DiscriminatorValue("PRODUCER")

public class UserProducerModel extends UserModel {

    @Column(nullable=false, unique = true)
    private String surname;
    @Column(nullable=false)
    private String farm;

    private double rating;

    private int qtdRating;

    private double sumRating;

    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductModel> products = new ArrayList<>();
    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReservationModel> reservations = new ArrayList<>();

    public UserProducerModel(String surname, String farm, double rating, int qtdRating, List<ProductModel> products, List<ReservationModel> reservations) {
        this.surname = surname;
        this.farm = farm;
        this.rating = rating;
        this.qtdRating = qtdRating;
        this.products = products;
        this.reservations = reservations;
    }

    public UserProducerModel() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFarm() {
        return farm;
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getQtdRating() {
        return qtdRating;
    }

    public void setQtdRating(int qtdRating) {
        this.qtdRating = qtdRating;
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }

    public List<ReservationModel> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationModel> reservations) {
        this.reservations = reservations;
    }

}

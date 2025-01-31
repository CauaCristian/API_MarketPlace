package com.caua.api_marketplace.Models.Relation;

import com.caua.api_marketplace.Models.Product.ProductModel;
import com.caua.api_marketplace.Models.User.UserClientModel;
import com.caua.api_marketplace.Models.User.UserProducerModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

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

}

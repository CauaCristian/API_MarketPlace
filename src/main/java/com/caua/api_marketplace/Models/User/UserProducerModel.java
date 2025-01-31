package com.caua.api_marketplace.Models.User;
import com.caua.api_marketplace.Models.Product.ProductModel;
import com.caua.api_marketplace.Models.Relation.ReservationModel;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "producer")
@DiscriminatorValue("PRODUCER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserProducerModel extends UserModel {

    @Column(nullable=false)
    private String surname;
    @Column(nullable=false)
    private String farm;
    @Column(nullable=false)
    private String rating;
    @Column(nullable=false)
    private String numRating;
    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductModel> products = new ArrayList<>();
    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReservationModel> reservations = new ArrayList<>();
}

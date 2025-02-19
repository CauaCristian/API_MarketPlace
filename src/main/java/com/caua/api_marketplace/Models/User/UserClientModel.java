package com.caua.api_marketplace.Models.User;
import com.caua.api_marketplace.Models.Relation.ReservationModel;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
@DiscriminatorValue("CLIENT")

public class UserClientModel extends UserModel {

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReservationModel> reservations = new ArrayList<>();

    public UserClientModel() {
    }

    public UserClientModel(List<ReservationModel> reservations) {
        this.reservations = reservations;
    }

    public List<ReservationModel> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationModel> reservations) {
        this.reservations = reservations;
    }

}

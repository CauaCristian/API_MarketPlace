package com.caua.api_marketplace.Models.User;
import jakarta.persistence.*;

@Entity
@Table(name = "admin")
@DiscriminatorValue("ADMIN")

public class UserAdminModel extends UserModel {

    @Column(nullable=false)
    private String identification;

    public UserAdminModel() {
    }

    public UserAdminModel(String identification) {
        this.identification = identification;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

}

package com.caua.api_marketplace.Models.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "admin")
@DiscriminatorValue("ADMIN")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserAdminModel extends UserModel {
    @Column(nullable=false)
    private String identification;
}

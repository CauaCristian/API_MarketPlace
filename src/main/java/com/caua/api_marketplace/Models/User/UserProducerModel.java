package com.caua.api_marketplace.Models.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.time.LocalDate;

@Entity
@Table(name = "producer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserProducerModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable=false)
    private String password;
    @Column(nullable=false)
    private String email;
    @Column(nullable=false)
    private String phone;
    @Column(nullable=false)
    private String address;
    @Column(nullable=false)
    private String cpf;
    @Column(nullable=false)
    private LocalDate dateOfBirth;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imagem;
    @Column(nullable=false)
    private String surname;
    @Column(nullable=false)
    private String farm;
    @Column(nullable=false)
    private String rating;
    @Column(nullable=false)
    private String numRating;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

}

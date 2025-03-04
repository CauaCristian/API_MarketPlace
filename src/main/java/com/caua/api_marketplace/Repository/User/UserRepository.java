package com.caua.api_marketplace.Repository.User;

import com.caua.api_marketplace.Models.User.UserModel;
import com.caua.api_marketplace.Models.User.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserDetails findByUsername(String username);
    UserModel findByUsernameIgnoreCase(String username);
    UserModel findByEmail(String email);
    UserModel findByPhone(String phone);
    UserModel findByCpf(String cpf);

    List<UserModel> findByRole(UserRole role);
}

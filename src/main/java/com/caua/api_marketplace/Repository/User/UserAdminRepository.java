package com.caua.api_marketplace.Repository.User;

import com.caua.api_marketplace.Models.User.UserAdminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAdminRepository extends JpaRepository<UserAdminModel, Long> {
}
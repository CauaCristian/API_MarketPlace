package com.caua.api_marketplace.Repository.User;

import com.caua.api_marketplace.Models.User.UserProducerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProducerRepository extends JpaRepository<UserProducerModel, Long> {
    UserProducerModel findBySurname(String surname);
}

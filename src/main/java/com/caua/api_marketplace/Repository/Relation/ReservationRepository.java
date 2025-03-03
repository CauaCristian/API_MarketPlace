package com.caua.api_marketplace.Repository.Relation;

import com.caua.api_marketplace.Models.Relation.ReservationModel;
import com.caua.api_marketplace.Models.User.UserClientModel;
import com.caua.api_marketplace.Models.User.UserProducerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationModel,Long> {
    List<ReservationModel> findByProducer(UserProducerModel producer);

    List<ReservationModel> findByClient(UserClientModel client);
}

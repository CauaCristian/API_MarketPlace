package com.caua.api_marketplace.Repository.Relation;

import com.caua.api_marketplace.Models.Relation.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationModel,Long> {
}

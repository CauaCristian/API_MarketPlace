package com.caua.api_marketplace.Services;

import com.caua.api_marketplace.DTO.Generic.ResponseDTO;
import com.caua.api_marketplace.DTO.Relation.CreateReservationDTO;
import com.caua.api_marketplace.DTO.Relation.ReservationDTO;
import com.caua.api_marketplace.Mappers.ReservationMapper;
import com.caua.api_marketplace.Models.Relation.ReservationModel;
import com.caua.api_marketplace.Repository.Relation.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ReservationMapper  reservationMapper;

    public ResponseDTO<ReservationDTO> createReservation(CreateReservationDTO createReservationDTO) {
        ReservationModel reservationModel =  reservationRepository.save(reservationMapper.createReservationDTOToReservationModel(createReservationDTO));
        ReservationDTO reservationDTO = reservationMapper.reservationModelToReservationDTO(reservationModel);
        return new ResponseDTO<ReservationDTO>("Reserva criado com sucesso",false,reservationDTO);
    }
}

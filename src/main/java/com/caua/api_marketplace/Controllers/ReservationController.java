package com.caua.api_marketplace.Controllers;

import com.caua.api_marketplace.DTO.Generic.ResponseDTO;
import com.caua.api_marketplace.DTO.Relation.CreateReservationDTO;
import com.caua.api_marketplace.DTO.Relation.ReservationDTO;
import com.caua.api_marketplace.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<ReservationDTO> createReservation(@RequestBody CreateReservationDTO createReservationDTO) {
        return reservationService.createReservation(createReservationDTO);
    }
}

package com.caua.api_marketplace.Controllers;

import com.caua.api_marketplace.DTO.Generic.ResponseDTO;
import com.caua.api_marketplace.DTO.Relation.CreateReservationDTO;
import com.caua.api_marketplace.DTO.Relation.ReservationDTO;
import com.caua.api_marketplace.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @GetMapping(value = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<List<ReservationDTO>> getAll(){
        return this.reservationService.getAll();
    }
    @GetMapping(value = "/getAllByProducer/{idProducer}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<List<ReservationDTO>> getAllByProducer(@PathVariable Long idProducer){
        return this.reservationService.getAllByProducer(idProducer);
    }
    @GetMapping(value = "/getAllByClient/{idClient}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<List<ReservationDTO>> getAllByClient(@PathVariable Long idClient){
        return this.reservationService.getAllByClient(idClient);
    }
    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<ReservationDTO> createReservation(@RequestBody CreateReservationDTO createReservationDTO) {
        return this.reservationService.createReservation(createReservationDTO);
    }
    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<ReservationDTO>  updateReservation(@RequestBody ReservationDTO reservationDTO) {
        return this.reservationService.updateReservation(reservationDTO);
    }
    @DeleteMapping(value = "/delete/{idReservation}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<ReservationDTO> deleteReservation(@PathVariable Long idReservation) {
        return this.reservationService.deleteReservation(idReservation);
    }

}

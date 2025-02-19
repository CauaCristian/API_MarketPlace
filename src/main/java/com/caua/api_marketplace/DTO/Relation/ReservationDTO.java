package com.caua.api_marketplace.DTO.Relation;
import java.time.LocalDate;

public class ReservationDTO {
    private Long id;

    private Long clientId;

    private Long producerId;

    private Long productId;

    private int quantity;

    private double price;

    private LocalDate dateReservation;

    private String status;
}

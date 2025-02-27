package com.caua.api_marketplace.Mappers;

import com.caua.api_marketplace.DTO.Relation.ReservationDTO;
import com.caua.api_marketplace.Models.Product.ProductModel;
import com.caua.api_marketplace.Models.Relation.ReservationModel;
import com.caua.api_marketplace.Models.User.UserClientModel;
import com.caua.api_marketplace.Models.User.UserProducerModel;
import com.caua.api_marketplace.Repository.Product.ProductRepository;
import com.caua.api_marketplace.Repository.Relation.ReservationRepository;
import com.caua.api_marketplace.Repository.User.UserClientRepository;
import com.caua.api_marketplace.Repository.User.UserProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationMapper {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserProducerRepository userProducerRepository;

    @Autowired
    private UserClientRepository userClientRepository;

    public ReservationModel reservationDTOToReservationModel(ReservationDTO reservationDTO){
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setId(reservationDTO.getId());
        reservationModel.setDateReservation(reservationDTO.getDateReservation());
        reservationModel.setPrice(reservationDTO.getPrice());
        reservationModel.setQuantity(reservationDTO.getQuantity());
        reservationModel.setStatus(reservationDTO.getStatus());
        ProductModel productModel = productRepository.findById(reservationDTO.getProductId()).get();
        UserProducerModel userProducerModel = userProducerRepository.findById(reservationDTO.getProducerId()).get();
        UserClientModel userClientModel = userClientRepository.findById(reservationDTO.getClientId()).get();
        if(productModel != null){
            if(userProducerModel != null){
                if(userClientModel != null){
                    reservationModel.setProduct(productModel);
                    reservationModel.setProducer(userProducerModel);
                    reservationModel.setClient(userClientModel);
                    return reservationModel;
                }
                else throw new RuntimeException("client id invalido");
            }
            else throw new RuntimeException("producer id invalido");
        }
        else throw new RuntimeException("product id invalido");
    }
    public ReservationDTO reservationModelToReservationDTO(ReservationModel reservationModel){
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(reservationModel.getId());
        reservationDTO.setDateReservation(reservationModel.getDateReservation());
        reservationDTO.setPrice(reservationModel.getPrice());
        reservationDTO.setQuantity(reservationModel.getQuantity());
        reservationDTO.setStatus(reservationModel.getStatus());
        reservationDTO.setClientId(reservationModel.getClient().getId());
        reservationDTO.setProductId(reservationModel.getProduct().getId());
        reservationDTO.setProducerId(reservationModel.getProducer().getId());
        return reservationDTO;
    }
}

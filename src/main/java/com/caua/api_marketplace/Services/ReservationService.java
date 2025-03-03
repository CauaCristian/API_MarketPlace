package com.caua.api_marketplace.Services;

import com.caua.api_marketplace.DTO.Generic.ResponseDTO;
import com.caua.api_marketplace.DTO.Relation.CreateReservationDTO;
import com.caua.api_marketplace.DTO.Relation.ReservationDTO;
import com.caua.api_marketplace.Mappers.ReservationMapper;
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

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ReservationMapper  reservationMapper;
    @Autowired
    private UserProducerRepository userProducerRepository;
    @Autowired
    private UserClientRepository userClientRepository;
    @Autowired
    private  ProductRepository productRepository;

    public ResponseDTO<ReservationDTO> createReservation(CreateReservationDTO createReservationDTO) {
        ReservationModel reservationModel =  this.reservationRepository.save(reservationMapper.createReservationDTOToReservationModel(createReservationDTO));
        ReservationDTO reservationDTO = this.reservationMapper.reservationModelToReservationDTO(reservationModel);
        return new ResponseDTO<ReservationDTO>("Reserva criado com sucesso",false,reservationDTO);
    }
    public ResponseDTO<List<ReservationDTO>> getAll() {
        List<ReservationModel> reservationModelList = this.reservationRepository.findAll();
        List<ReservationDTO> reservationDTOList = this.reservationMapper.listReservationsModelToReservationDTO(reservationModelList);
        return new ResponseDTO<>("Lista de reservas retornada com sucesso",false,reservationDTOList);
    }
    public ResponseDTO<List<ReservationDTO>> getAllByProducer(Long idProducer) {
        UserProducerModel userProducerModel = this.userProducerRepository.findById(idProducer).orElse(null);
        if(userProducerModel == null)return new ResponseDTO<>("producer id incorreto",true,null);
        List<ReservationModel> reservationModelList = this.reservationRepository.findByProducer(userProducerModel);
        List<ReservationDTO> reservationDTOList = this.reservationMapper.listReservationsModelToReservationDTO(reservationModelList);
        return new ResponseDTO<>("Lista de reservas por produtor id retornada com sucesso",false,reservationDTOList);
    }
    public ResponseDTO<List<ReservationDTO>> getAllByClient(Long idClient) {
        UserClientModel userClientModel = this.userClientRepository.findById(idClient).orElse(null);
        if(userClientModel == null)return new ResponseDTO<>("client id incorreto",true,null);
        List<ReservationModel> listReservationModel = this.reservationRepository.findByClient(userClientModel);
        List<ReservationDTO> listReservationDTO = this.reservationMapper.listReservationsModelToReservationDTO(listReservationModel);
        return new ResponseDTO<>("Lista de reservas por cliente id retornada com sucesso",false,listReservationDTO);
    }
    public ResponseDTO<ReservationDTO> updateReservation(ReservationDTO reservationDTO) {
        ReservationModel reservationModel = this.reservationRepository.findById(reservationDTO.getId()).orElse(null);
        if(reservationModel == null) return new ResponseDTO<>("reservation id incorreto",true,null);
        ProductModel productModel = this.productRepository.findById(reservationDTO.getProductId()).orElse(null);
        if(productModel == null) return new ResponseDTO<>("product id incorreto",true,null);
        reservationModel.setProduct(productModel);
        reservationModel.setQuantity(reservationDTO.getQuantity());
        reservationModel.setDateReservation(reservationDTO.getDateReservation());
        
    }
}

package com.caua.api_marketplace.Mappers;

import com.caua.api_marketplace.DTO.User.UserAdminDTO;
import com.caua.api_marketplace.DTO.User.UserClientDTO;
import com.caua.api_marketplace.DTO.User.UserProducerDTO;
import com.caua.api_marketplace.Models.User.UserAdminModel;
import com.caua.api_marketplace.Models.User.UserClientModel;
import com.caua.api_marketplace.Models.User.UserProducerModel;
import com.caua.api_marketplace.Models.User.UserRole;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserClientModel userClientDTOToUserClientModel(UserClientDTO userClientDTO) {
        UserClientModel userClientModel = new UserClientModel();
        userClientModel.setUsername(userClientDTO.getUsername());
        userClientModel.setEmail(userClientDTO.getEmail());
        userClientModel.setAddress(userClientDTO.getAddress());
        userClientModel.setPhone(userClientDTO.getPhone());
        userClientModel.setImage(userClientDTO.getImage());
        userClientModel.setCpf(userClientDTO.getCpf());
        userClientModel.setDateOfBirth(userClientDTO.getDateOfBirth());
        userClientModel.setRole(UserRole.UserClient);
        return userClientModel;
    }
    public UserClientDTO userClientModelToUserClientDTO(UserClientModel userClientModel) {
        UserClientDTO userClientDTO = new UserClientDTO();
        userClientDTO.setUsername(userClientModel.getUsername());
        userClientDTO.setEmail(userClientModel.getEmail());
        userClientDTO.setAddress(userClientModel.getAddress());
        userClientDTO.setPhone(userClientModel.getPhone());
        userClientDTO.setImage(userClientModel.getImage());
        userClientDTO.setCpf(userClientModel.getCpf());
        userClientDTO.setDateOfBirth(userClientModel.getDateOfBirth());
        return userClientDTO;
    }
    public UserProducerModel userProducerDTOToUserProducerModel(UserProducerDTO userProducerDTO) {
        UserProducerModel userProducerModel = new UserProducerModel();
        userProducerModel.setUsername(userProducerDTO.getUsername());
        userProducerModel.setEmail(userProducerDTO.getEmail());
        userProducerModel.setAddress(userProducerDTO.getAddress());
        userProducerModel.setPhone(userProducerDTO.getPhone());
        userProducerModel.setImage(userProducerDTO.getImage());
        userProducerModel.setCpf(userProducerDTO.getCpf());
        userProducerModel.setDateOfBirth(userProducerDTO.getDateOfBirth());
        userProducerModel.setSurname(userProducerDTO.getSurname());
        userProducerModel.setRating(userProducerDTO.getRating());
        userProducerModel.setNumRating(userProducerDTO.getNumRating());
        userProducerModel.setFarm(userProducerDTO.getFarm());
        userProducerModel.setRole(UserRole.UserProducer);
        return userProducerModel;
    }
    public UserProducerDTO userProducerModelToUserProducerDTO(UserProducerModel userProducerModel) {
        UserProducerDTO userProducerDTO = new UserProducerDTO();
        userProducerDTO.setUsername(userProducerModel.getUsername());
        userProducerDTO.setEmail(userProducerModel.getEmail());
        userProducerDTO.setAddress(userProducerModel.getAddress());
        userProducerDTO.setPhone(userProducerModel.getPhone());
        userProducerDTO.setImage(userProducerModel.getImage());
        userProducerDTO.setCpf(userProducerModel.getCpf());
        userProducerDTO.setDateOfBirth(userProducerModel.getDateOfBirth());
        userProducerDTO.setSurname(userProducerModel.getSurname());
        userProducerDTO.setRating(userProducerModel.getRating());
        userProducerDTO.setNumRating(userProducerModel.getNumRating());
        userProducerDTO.setFarm(userProducerModel.getFarm());
        return userProducerDTO;
    }
    public UserAdminModel userAdminDTOToUserAdminModel(UserAdminDTO userAdminDTO) {
        UserAdminModel userAdminModel = new UserAdminModel();
        userAdminModel.setUsername(userAdminDTO.getUsername());
        userAdminModel.setEmail(userAdminDTO.getEmail());
        userAdminModel.setAddress(userAdminDTO.getAddress());
        userAdminModel.setPhone(userAdminDTO.getPhone());
        userAdminModel.setImage(userAdminDTO.getImage());
        userAdminModel.setCpf(userAdminDTO.getCpf());
        userAdminModel.setDateOfBirth(userAdminDTO.getDateOfBirth());
        userAdminModel.setIdentification(userAdminDTO.getIdentification());
        userAdminModel.setRole(UserRole.UserAdmin);
        return userAdminModel;
    }
    public UserAdminDTO userAdminModelToUserAdminDTO(UserAdminModel userAdminModel) {
        UserAdminDTO userAdminDTO = new UserAdminDTO();
        userAdminDTO.setUsername(userAdminModel.getUsername());
        userAdminDTO.setEmail(userAdminModel.getEmail());
        userAdminDTO.setAddress(userAdminModel.getAddress());
        userAdminDTO.setPhone(userAdminModel.getPhone());
        userAdminDTO.setImage(userAdminModel.getImage());
        userAdminDTO.setCpf(userAdminModel.getCpf());
        userAdminDTO.setDateOfBirth(userAdminModel.getDateOfBirth());
        userAdminDTO.setIdentification(userAdminModel.getIdentification());

        return userAdminDTO;
    }
}

package com.caua.api_marketplace.Mappers;

import com.caua.api_marketplace.DTO.Auth.RegisterAdminDTO;
import com.caua.api_marketplace.DTO.Auth.RegisterClientDTO;
import com.caua.api_marketplace.DTO.Auth.RegisterProducerDTO;
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
    public UserClientModel registerClientDTOToUserClientModel(RegisterClientDTO registerClientDTO) {
        UserClientModel userClientModel = new UserClientModel();
        userClientModel.setUsername(registerClientDTO.getUsername());
        userClientModel.setEmail(registerClientDTO.getEmail());
        userClientModel.setPassword(registerClientDTO.getPassword());
        userClientModel.setRole(UserRole.UserClient);
        userClientModel.setCpf(registerClientDTO.getCpf());
        userClientModel.setPhone(registerClientDTO.getPhone());
        userClientModel.setAddress(registerClientDTO.getAddress());
        userClientModel.setDateOfBirth(registerClientDTO.getDateOfBirth());
        userClientModel.setImage(registerClientDTO.getImage());
        return userClientModel;
    }
    public UserClientModel userClientDTOToUserClientModel(UserClientDTO userClientDTO) {
        UserClientModel userClientModel = new UserClientModel();
        userClientModel.setId(userClientDTO.getId());
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
        userClientDTO.setId(userClientModel.getId());
        userClientDTO.setEmail(userClientModel.getEmail());
        userClientDTO.setAddress(userClientModel.getAddress());
        userClientDTO.setPhone(userClientModel.getPhone());
        userClientDTO.setImage(userClientModel.getImage());
        userClientDTO.setCpf(userClientModel.getCpf());
        userClientDTO.setDateOfBirth(userClientModel.getDateOfBirth());
        return userClientDTO;
    }
    public UserProducerModel registerProducerDTOToUserProducerModel(RegisterProducerDTO registerProducerDTO) {
        UserProducerModel userProducerModel = new UserProducerModel();
        userProducerModel.setUsername(registerProducerDTO.getUsername());
        userProducerModel.setEmail(registerProducerDTO.getEmail());
        userProducerModel.setAddress(registerProducerDTO.getAddress());
        userProducerModel.setPhone(registerProducerDTO.getPhone());
        userProducerModel.setImage(registerProducerDTO.getImage());
        userProducerModel.setCpf(registerProducerDTO.getCpf());
        userProducerModel.setDateOfBirth(registerProducerDTO.getDateOfBirth());
        userProducerModel.setRole(UserRole.UserProducer);
        userProducerModel.setPassword(registerProducerDTO.getPassword());
        userProducerModel.setFarm(registerProducerDTO.getFarm());
        userProducerModel.setSurname(registerProducerDTO.getSurname());
        return userProducerModel;
    }
    public UserProducerModel userProducerDTOToUserProducerModel(UserProducerDTO userProducerDTO) {
        UserProducerModel userProducerModel = new UserProducerModel();
        userProducerModel.setUsername(userProducerDTO.getUsername());
        userProducerModel.setId(userProducerDTO.getId());
        userProducerModel.setEmail(userProducerDTO.getEmail());
        userProducerModel.setAddress(userProducerDTO.getAddress());
        userProducerModel.setPhone(userProducerDTO.getPhone());
        userProducerModel.setImage(userProducerDTO.getImage());
        userProducerModel.setCpf(userProducerDTO.getCpf());
        userProducerModel.setDateOfBirth(userProducerDTO.getDateOfBirth());
        userProducerModel.setSurname(userProducerDTO.getSurname());
        userProducerModel.setFarm(userProducerDTO.getFarm());
        userProducerModel.setRole(UserRole.UserProducer);
        return userProducerModel;
    }
    public UserProducerDTO userProducerModelToUserProducerDTO(UserProducerModel userProducerModel) {
        UserProducerDTO userProducerDTO = new UserProducerDTO();
        userProducerDTO.setUsername(userProducerModel.getUsername());
        userProducerDTO.setId(userProducerModel.getId());
        userProducerDTO.setEmail(userProducerModel.getEmail());
        userProducerDTO.setAddress(userProducerModel.getAddress());
        userProducerDTO.setPhone(userProducerModel.getPhone());
        userProducerDTO.setImage(userProducerModel.getImage());
        userProducerDTO.setCpf(userProducerModel.getCpf());
        userProducerDTO.setDateOfBirth(userProducerModel.getDateOfBirth());
        userProducerDTO.setSurname(userProducerModel.getSurname());
        userProducerDTO.setRating(userProducerModel.getRating());
        userProducerDTO.setFarm(userProducerModel.getFarm());
        return userProducerDTO;
    }
    public UserAdminModel registerAdminDTOToUserAdminModel(RegisterAdminDTO registerAdminDTO) {
        UserAdminModel userAdminModel = new UserAdminModel();
        userAdminModel.setUsername(registerAdminDTO.getUsername());
        userAdminModel.setPassword(registerAdminDTO.getPassword());
        userAdminModel.setEmail(registerAdminDTO.getEmail());
        userAdminModel.setAddress(registerAdminDTO.getAddress());
        userAdminModel.setPhone(registerAdminDTO.getPhone());
        userAdminModel.setImage(registerAdminDTO.getImage());
        userAdminModel.setCpf(registerAdminDTO.getCpf());
        userAdminModel.setDateOfBirth(registerAdminDTO.getDateOfBirth());
        userAdminModel.setRole(UserRole.UserAdmin);
        userAdminModel.setIdentification(registerAdminDTO.getIdentification());
        return userAdminModel;
    }
    public UserAdminModel userAdminDTOToUserAdminModel(UserAdminDTO userAdminDTO) {
        UserAdminModel userAdminModel = new UserAdminModel();
        userAdminModel.setUsername(userAdminDTO.getUsername());
        userAdminModel.setId(userAdminDTO.getId());
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
        userAdminDTO.setId(userAdminModel.getId());
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

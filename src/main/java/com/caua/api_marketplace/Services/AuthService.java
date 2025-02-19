package com.caua.api_marketplace.Services;

import com.caua.api_marketplace.Models.Product.ProductModel;
import com.caua.api_marketplace.Models.Relation.ReservationModel;
import com.caua.api_marketplace.Models.User.UserAdminModel;
import com.caua.api_marketplace.Models.User.UserClientModel;
import com.caua.api_marketplace.Models.User.UserProducerModel;
import com.caua.api_marketplace.Repository.User.UserAdminRepository;
import com.caua.api_marketplace.Repository.User.UserClientRepository;
import com.caua.api_marketplace.Repository.User.UserProducerRepository;
import com.caua.api_marketplace.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAdminRepository userAdminRepository;
    @Autowired
    private UserClientRepository userClientRepository;
    @Autowired
    private UserProducerRepository userProducerRepository;

    public UserClientModel registerUserClient(String userName, String password, String email, String cpf, String phone, String address, LocalDate dateOfBirth) {
        UserClientModel userClient = new UserClientModel();
        userClient.setUsername(userName);
        userClient.setPassword(password);
        userClient.setEmail(email);
        userClient.setCpf(cpf);
        userClient.setPhone(phone);
        userClient.setAddress(address);
        userClient.setDateOfBirth(dateOfBirth);
        return userClientRepository.save(userClient);
    }

    public UserProducerModel registerUserProducer(String userName, String password, String email, String cpf, String phone, String address, LocalDate dateOfBirth, String farm, List<ProductModel> products, String numRating, String rating, List<ReservationModel> reservations, String surname) {
        UserProducerModel userProducer = new UserProducerModel();
        userProducer.setUsername(userName);
        userProducer.setPassword(password);
        userProducer.setEmail(email);
        userProducer.setCpf(cpf);
        userProducer.setPhone(phone);
        userProducer.setAddress(address);
        userProducer.setDateOfBirth(dateOfBirth);
        userProducer.setFarm(farm);
        userProducer.setProducts(products);
        userProducer.setNumRating(numRating);
        userProducer.setRating(rating);
        userProducer.setReservations(reservations);
        userProducer.setSurname(surname);
        return userProducerRepository.save(userProducer);
    }

    public UserAdminModel registerUserAdmin(String userName, String password, String email, String cpf, String phone, String address, LocalDate dateOfBirth, String identification) {
        UserAdminModel userAdmin = new UserAdminModel();
        userAdmin.setUsername(userName);
        userAdmin.setPassword(password);
        userAdmin.setCpf(cpf);
        userAdmin.setPhone(phone);
        userAdmin.setAddress(address);
        userAdmin.setEmail(email);
        userAdmin.setDateOfBirth(dateOfBirth);
        userAdmin.setIdentification(identification);
        return userAdminRepository.save(userAdmin);
    }
}

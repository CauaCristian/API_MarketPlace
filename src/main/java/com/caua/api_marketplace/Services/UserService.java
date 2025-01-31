package com.caua.api_marketplace.Services;
import com.caua.api_marketplace.Models.User.UserAdminModel;
import com.caua.api_marketplace.Repository.User.UserAdminRepository;
import com.caua.api_marketplace.Repository.User.UserClientRepository;
import com.caua.api_marketplace.Repository.User.UserProducerRepository;
import com.caua.api_marketplace.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAdminRepository userAdminRepository;
    @Autowired
    private UserClientRepository userClientRepository;
    @Autowired
    private UserProducerRepository userProducerRepository;

    public UserAdminModel createUserAdmin() {

    UserAdminModel userAdmin = new UserAdminModel();

    userAdmin.setUsername("admin");
    userAdmin.setPassword("admin");
    userAdmin.setCpf("admin");
    userAdmin.setPhone("admin");
    userAdmin.setAddress("admin");
    userAdmin.setEmail("admin@admin.com");
    userAdmin.setDateOfBirth(LocalDate.now());

    userAdmin.setIdentification("admin");

    return userAdminRepository.save(userAdmin);

    }
}

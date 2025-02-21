package com.caua.api_marketplace.Services;

import com.caua.api_marketplace.DTO.User.UserAdminDTO;
import com.caua.api_marketplace.DTO.User.UserClientDTO;
import com.caua.api_marketplace.DTO.User.UserProducerDTO;
import com.caua.api_marketplace.Mappers.UserMapper;
import com.caua.api_marketplace.Models.User.UserAdminModel;
import com.caua.api_marketplace.Models.User.UserClientModel;
import com.caua.api_marketplace.Models.User.UserProducerModel;
import com.caua.api_marketplace.Models.User.UserRole;
import com.caua.api_marketplace.Repository.User.UserAdminRepository;
import com.caua.api_marketplace.Repository.User.UserClientRepository;
import com.caua.api_marketplace.Repository.User.UserProducerRepository;
import com.caua.api_marketplace.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAdminRepository userAdminRepository;
    @Autowired
    private UserClientRepository userClientRepository;
    @Autowired
    private UserProducerRepository userProducerRepository;

    public UserClientModel registerUserClient(UserClientDTO userClientDTO) {
        UserClientModel userClientModel = userMapper.userClientDTOToUserClientModel(userClientDTO);
        userClientModel.setRole(UserRole.UserClient);
        return userClientRepository.save(userClientModel);
    }

    public UserProducerModel registerUserProducer(UserProducerDTO userProducerDTO) {
        UserProducerModel userProducerModel = userMapper.userProducerDTOToUserProducerModel(userProducerDTO);
        userProducerModel.setRole(UserRole.UserProducer);
        return userProducerRepository.save(userProducerModel);
    }

    public UserAdminModel registerUserAdmin(UserAdminDTO userAdminDTO) {
        UserAdminModel userAdminModel = userMapper.userAdminDTOToUserAdminModel(userAdminDTO);
        userAdminModel.setRole(UserRole.UserAdmin);
        return userAdminRepository.save(userAdminModel);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}

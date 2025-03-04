package com.caua.api_marketplace.Services;
import com.caua.api_marketplace.DTO.Generic.ResponseDTO;
import com.caua.api_marketplace.Mappers.UserMapper;
import com.caua.api_marketplace.Models.User.UserModel;
import com.caua.api_marketplace.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    public ResponseDTO<List<Object>> getAll(){
        List<UserModel> ListUsersModels = userRepository.findAll();
        List<Object> ListUsersObject = userMapper.ListUserModelsToListObjects(ListUsersModels);
        return new ResponseDTO<>("Lista de usuarios retornada com sucesso",false,ListUsersObject);
    }
    public ResponseDTO<List<Object>> getByUserType(String userType){

    }
}

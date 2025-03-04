package com.caua.api_marketplace.Services;
import com.caua.api_marketplace.DTO.Generic.ResponseDTO;
import com.caua.api_marketplace.Mappers.UserMapper;
import com.caua.api_marketplace.Models.User.UserModel;
import com.caua.api_marketplace.Models.User.UserRole;
import com.caua.api_marketplace.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    public ResponseDTO<List<Object>> getAll(){
        List<UserModel> ListUsersModels = this.userRepository.findAll();
        List<Object> ListUsersObject = this.userMapper.ListUserModelsToListObjects(ListUsersModels);
        return new ResponseDTO<>("Lista de usuarios retornada com sucesso",false,ListUsersObject);
    }
    public ResponseDTO<List<Object>> getAllByUserType(String userType){
        UserRole userRole;
        switch (userType.toLowerCase()) {
            case "admin":
                userRole = UserRole.UserAdmin;
                break;
            case "client":
                userRole = UserRole.UserClient;
                break;
            case "producer":
                userRole = UserRole.UserProducer;
                break;
            default:
                throw new RuntimeException("Tipo de usuário inválido: " + userType);
        }
        List<UserModel> listUsersModels = this.userRepository.findByRole(userRole);
        List<Object> ListUsersObject = this.userMapper.ListUserModelsToListObjects(listUsersModels);
        return new ResponseDTO<>("Lista de usuarios por type retornada com sucesso",false,ListUsersObject);
    }
    public ResponseDTO<Object> getByUsername(String username){
        UserModel userModel = this.userRepository.findByUsernameIgnoreCase(username);
        if(userModel == null) return new ResponseDTO<>("Usuario inexistente",true,null);
        Object userObject = this.userMapper.UserModelToObject(userModel);
        return new ResponseDTO<>("Usuario encontrado",false,userObject);
    }
}

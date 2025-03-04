package com.caua.api_marketplace.Services;
import com.caua.api_marketplace.DTO.Generic.ResponseDTO;
import com.caua.api_marketplace.DTO.User.UserAdminDTO;
import com.caua.api_marketplace.DTO.User.UserClientDTO;
import com.caua.api_marketplace.DTO.User.UserProducerDTO;
import com.caua.api_marketplace.Mappers.UserMapper;
import com.caua.api_marketplace.Models.User.*;
import com.caua.api_marketplace.Repository.User.UserAdminRepository;
import com.caua.api_marketplace.Repository.User.UserClientRepository;
import com.caua.api_marketplace.Repository.User.UserProducerRepository;
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
    UserClientRepository userClientRepository;
    @Autowired
    UserProducerRepository userProducerRepository;
    @Autowired
    UserAdminRepository userAdminRepository;
    @Autowired
    UserMapper userMapper;

    public ResponseDTO<List<Object>> getAll(){
        List<UserModel> ListUsersModels = this.userRepository.findAll();
        List<Object> ListUsersObject = this.userMapper.listUserModelsToListObjects(ListUsersModels);
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
        List<Object> ListUsersObject = this.userMapper.listUserModelsToListObjects(listUsersModels);
        return new ResponseDTO<>("Lista de usuarios por type retornada com sucesso",false,ListUsersObject);
    }
    public ResponseDTO<Object> getByUsername(String username){
        UserModel userModel = this.userRepository.findByUsernameIgnoreCase(username);
        if(userModel == null) return new ResponseDTO<>("Usuario inexistente",true,null);
        Object userObject = this.userMapper.userModelToObject(userModel);
        return new ResponseDTO<>("Usuario encontrado",false,userObject);
    }
    public ResponseDTO<UserClientDTO> updateUserClient(UserClientDTO userClientDTO){
        UserClientModel userClientModel = this.userClientRepository.findById(userClientDTO.getId()).orElse(null);
        if(userClientModel == null) return new ResponseDTO<>("Id de usuario inexistente",true,null);
        userClientModel.setUsername(userClientDTO.getUsername());
        userClientModel.setImage(userClientDTO.getImage());
        userClientModel.setAddress(userClientDTO.getAddress());
        userClientModel.setPhone(userClientDTO.getPhone());
        this.userClientRepository.save(userClientModel);
        UserClientDTO userClientDTOModed = this.userMapper.userClientModelToUserClientDTO(userClientModel);
        return new ResponseDTO<>("Cliente atualizado com sucesso",false,userClientDTOModed);
    }
    public ResponseDTO<UserProducerDTO> updateUserProducer(UserProducerDTO userProducerDTO){
        UserProducerModel userProducerModel = this.userProducerRepository.findById(userProducerDTO.getId()).orElse(null);
        if(userProducerModel == null) return new ResponseDTO<>("Id de usuario inexistente",true,null);
        userProducerModel.setUsername(userProducerDTO.getUsername());
        userProducerModel.setImage(userProducerDTO.getImage());
        userProducerModel.setAddress(userProducerDTO.getAddress());
        userProducerModel.setPhone(userProducerDTO.getPhone());
        userProducerModel.setFarm(userProducerDTO.getFarm());
        userProducerModel.setSurname(userProducerDTO.getSurname());
        this.userProducerRepository.save(userProducerModel);
        UserProducerDTO userProducerDTOModed = this.userMapper.userProducerModelToUserProducerDTO(userProducerModel);
        return new ResponseDTO<>("Produtor atualizado com sucesso",false,userProducerDTOModed);
    }
    public ResponseDTO<UserAdminDTO> updateUserAdmin(UserAdminDTO userAdminDTO){
        UserAdminModel userAdminModel = this.userAdminRepository.findById(userAdminDTO.getId()).orElse(null);
        if(userAdminModel == null) return new ResponseDTO<>("Id de usuario inexistente",true,null);
        userAdminModel.setUsername(userAdminDTO.getUsername());
        userAdminModel.setImage(userAdminDTO.getImage());
        userAdminModel.setAddress(userAdminDTO.getAddress());
        userAdminModel.setPhone(userAdminDTO.getPhone());
        userAdminModel.setIdentification(userAdminDTO.getIdentification());
        this.userAdminRepository.save(userAdminModel);
        UserAdminDTO userAdminDTOModed = this.userMapper.userAdminModelToUserAdminDTO(userAdminModel);
        return new ResponseDTO<>("Admin atualizado com sucesso",false,userAdminDTOModed);
    }
    public ResponseDTO<Object> deleteUser(Long userId){
        UserModel userModel = this.userRepository.findById(userId).orElse(null);
        if(userModel == null) return new ResponseDTO<>("Id de usuario inexistente",true,null);
        this.userRepository.delete(userModel);
        Object userObject = this.userMapper.userModelToObject(userModel);
        return new ResponseDTO<>("Usuario deletado com sucesso",false,userObject);
    }
}

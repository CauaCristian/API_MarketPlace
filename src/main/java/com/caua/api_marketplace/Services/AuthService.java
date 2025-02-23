package com.caua.api_marketplace.Services;
import com.caua.api_marketplace.DTO.Response.ResponseDTO;
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
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
    private TokenService tokenService;
    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;

    public ResponseDTO<UserDetails> login(String username, String password){
        var usernamePassword = new UsernamePasswordAuthenticationToken(username, password);
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UserModel) auth.getPrincipal());
        return new ResponseDTO<UserDetails>("login efetuado com sucesso",false,token, loadUserByUsername(username));
    }

    public ResponseDTO<UserClientModel> registerUserClient(UserClientDTO userClientDTO) {
        UserClientModel userClientModel = userMapper.userClientDTOToUserClientModel(userClientDTO);
        userClientModel.setRole(UserRole.UserClient);
        String EncryptedPassword = new BCryptPasswordEncoder().encode(userClientDTO.getPassword());
        userClientModel.setPassword(EncryptedPassword);
        var usernamePassword = new UsernamePasswordAuthenticationToken(userClientDTO.getUsername(), userClientDTO.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UserModel) auth.getPrincipal());
        return new ResponseDTO<UserClientModel>("registro efetuado com sucesso",false,token, userClientRepository.save(userClientModel));
    }

    public ResponseDTO<UserProducerModel> registerUserProducer(UserProducerDTO userProducerDTO) {
        UserProducerModel userProducerModel = userMapper.userProducerDTOToUserProducerModel(userProducerDTO);
        userProducerModel.setRole(UserRole.UserProducer);
        String EncryptedPassword = new BCryptPasswordEncoder().encode(userProducerDTO.getPassword());
        userProducerModel.setPassword(EncryptedPassword);
        var usernamePassword = new UsernamePasswordAuthenticationToken(userProducerDTO.getUsername(), userProducerDTO.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UserModel) auth.getPrincipal());
        return new ResponseDTO<UserProducerModel>("registro efetuado com sucesso",false,token, userProducerRepository.save(userProducerModel));
    }

    public ResponseDTO<UserAdminModel> registerUserAdmin(UserAdminDTO userAdminDTO) {
        UserAdminModel userAdminModel = userMapper.userAdminDTOToUserAdminModel(userAdminDTO);
        userAdminModel.setRole(UserRole.UserAdmin);
        String EncryptedPassword = new BCryptPasswordEncoder().encode(userAdminDTO.getPassword());
        userAdminModel.setPassword(EncryptedPassword);
        var usernamePassword = new UsernamePasswordAuthenticationToken(userAdminDTO.getUsername(), userAdminDTO.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UserModel) auth.getPrincipal());
        return new ResponseDTO<UserAdminModel>("registro efetuado com sucesso",false,token, userAdminRepository.save(userAdminModel));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}

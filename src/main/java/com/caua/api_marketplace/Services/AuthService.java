package com.caua.api_marketplace.Services;
import com.caua.api_marketplace.DTO.Auth.ResponseAuthDTO;
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

    public ResponseAuthDTO<UserDetails> login(String username, String password){
        var usernamePassword = new UsernamePasswordAuthenticationToken(username, password);
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UserModel) auth.getPrincipal());
        return new ResponseAuthDTO<UserDetails>("login efetuado com sucesso",false,token, loadUserByUsername(username));
    }

    public ResponseAuthDTO<UserClientModel> registerUserClient(UserClientDTO userClientDTO) {

        if(userRepository.findByUsername(userClientDTO.getUsername()) != null)return new ResponseAuthDTO<UserClientModel>("Username existente",true,null, null);
        if(userRepository.findByEmail(userClientDTO.getEmail()) != null)return new ResponseAuthDTO<UserClientModel>("email em uso",true,null, null);
        if(userRepository.findByPhone(userClientDTO.getPhone()) != null)return new ResponseAuthDTO<UserClientModel>("numero de telefone em uso",true,null, null);
        if(userRepository.findByCpf(userClientDTO.getCpf()) != null)return new ResponseAuthDTO<UserClientModel>("cpf em uso",true,null, null);

        UserClientModel userClientModel = userMapper.userClientDTOToUserClientModel(userClientDTO);
        userClientModel.setRole(UserRole.UserClient);
        String EncryptedPassword = new BCryptPasswordEncoder().encode(userClientDTO.getPassword());
        userClientModel.setPassword(EncryptedPassword);
        var userClient = userClientRepository.save(userClientModel);
        var usernamePassword = new UsernamePasswordAuthenticationToken(userClientDTO.getUsername(), userClientDTO.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UserModel) auth.getPrincipal());
        userClient.setPassword(null);
        return new ResponseAuthDTO<UserClientModel>("registro efetuado com sucesso",false,token, userClient);
    }

    public ResponseAuthDTO<UserProducerModel> registerUserProducer(UserProducerDTO userProducerDTO) {

        if(userRepository.findByUsername(userProducerDTO.getUsername()) != null)return new ResponseAuthDTO<UserProducerModel>("Username existente",true,null, null);
        if(userRepository.findByEmail(userProducerDTO.getEmail()) != null)return new ResponseAuthDTO<UserProducerModel>("Email em uso",true,null, null);
        if(userRepository.findByPhone(userProducerDTO.getPhone()) != null)return new ResponseAuthDTO<UserProducerModel>("Numero de telefone em uso",true,null, null);
        if(userRepository.findByCpf(userProducerDTO.getCpf()) != null)return new ResponseAuthDTO<UserProducerModel>("Cpf em uso",true,null, null);
        if(userProducerRepository.findBySurname(userProducerDTO.getSurname()) != null) return new ResponseAuthDTO<UserProducerModel>("Surname existente",true,null, null);

        UserProducerModel userProducerModel = userMapper.userProducerDTOToUserProducerModel(userProducerDTO);
        userProducerModel.setRole(UserRole.UserProducer);
        String EncryptedPassword = new BCryptPasswordEncoder().encode(userProducerDTO.getPassword());
        userProducerModel.setPassword(EncryptedPassword);
        var userProducer = userProducerRepository.save(userProducerModel);
        var usernamePassword = new UsernamePasswordAuthenticationToken(userProducerDTO.getUsername(), userProducerDTO.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UserModel) auth.getPrincipal());
        userProducer.setPassword(null);
        return new ResponseAuthDTO<UserProducerModel>("registro efetuado com sucesso",false,token, userProducer);
    }

    public ResponseAuthDTO<UserAdminModel> registerUserAdmin(UserAdminDTO userAdminDTO) {

        if(userRepository.findByUsername(userAdminDTO.getUsername()) != null)return new ResponseAuthDTO<UserAdminModel>("Username existente",true,null, null);
        if(userRepository.findByEmail(userAdminDTO.getEmail()) != null)return new ResponseAuthDTO<UserAdminModel>("Email em uso",true,null, null);
        if(userRepository.findByPhone(userAdminDTO.getPhone()) != null)return new ResponseAuthDTO<UserAdminModel>("Numero de telefone em uso",true,null, null);
        if(userRepository.findByCpf(userAdminDTO.getCpf()) != null)return new ResponseAuthDTO<UserAdminModel>("Cpf em uso",true,null, null);
        if(userAdminRepository.findByIdentification(userAdminDTO.getIdentification()) != null) return new ResponseAuthDTO<UserAdminModel>("identificaçao em uso",true,null, null);

        UserAdminModel userAdminModel = userMapper.userAdminDTOToUserAdminModel(userAdminDTO);
        userAdminModel.setRole(UserRole.UserAdmin);
        String EncryptedPassword = new BCryptPasswordEncoder().encode(userAdminDTO.getPassword());
        userAdminModel.setPassword(EncryptedPassword);
        var userAdmin = userAdminRepository.save(userAdminModel);
        var usernamePassword = new UsernamePasswordAuthenticationToken(userAdminDTO.getUsername(), userAdminDTO.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UserModel) auth.getPrincipal());
        userAdmin.setPassword(null);
        return new ResponseAuthDTO<UserAdminModel>("registro efetuado com sucesso",false,token, userAdmin);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}

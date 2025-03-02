package com.caua.api_marketplace.Services;
import com.caua.api_marketplace.DTO.Auth.RegisterAdminDTO;
import com.caua.api_marketplace.DTO.Auth.RegisterClientDTO;
import com.caua.api_marketplace.DTO.Auth.RegisterProducerDTO;
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

    public ResponseAuthDTO<UserClientDTO> registerUserClient(RegisterClientDTO registerClientDTO) {
        if(userRepository.findByUsername(registerClientDTO.getUsername()) != null)return new ResponseAuthDTO<UserClientDTO>("Username existente",true,null, null);
        if(userRepository.findByEmail(registerClientDTO.getEmail()) != null)return new ResponseAuthDTO<UserClientDTO>("email em uso",true,null, null);
        if(userRepository.findByPhone(registerClientDTO.getPhone()) != null)return new ResponseAuthDTO<UserClientDTO>("numero de telefone em uso",true,null, null);
        if(userRepository.findByCpf(registerClientDTO.getCpf()) != null)return new ResponseAuthDTO<UserClientDTO>("cpf em uso",true,null, null);

        UserClientModel userClientModel = userMapper.registerClientDTOToUserClientModel(registerClientDTO);
        String EncryptedPassword = new BCryptPasswordEncoder().encode(registerClientDTO.getPassword());
        userClientModel.setPassword(EncryptedPassword);
        UserClientModel userClient = userClientRepository.save(userClientModel);
        var usernamePassword = new UsernamePasswordAuthenticationToken(registerClientDTO.getUsername(), registerClientDTO.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UserModel) auth.getPrincipal());
        UserClientDTO userClientDTO = userMapper.userClientModelToUserClientDTO(userClient);
        return new ResponseAuthDTO<UserClientDTO>("registro efetuado com sucesso",false,token, userClientDTO);
    }

    public ResponseAuthDTO<UserProducerDTO> registerUserProducer(RegisterProducerDTO registerProducerDTO) {

        if(userRepository.findByUsername(registerProducerDTO.getUsername()) != null)return new ResponseAuthDTO<UserProducerDTO>("Username existente",true,null, null);
        if(userRepository.findByEmail(registerProducerDTO.getEmail()) != null)return new ResponseAuthDTO<UserProducerDTO>("Email em uso",true,null, null);
        if(userRepository.findByPhone(registerProducerDTO.getPhone()) != null)return new ResponseAuthDTO<UserProducerDTO>("Numero de telefone em uso",true,null, null);
        if(userRepository.findByCpf(registerProducerDTO.getCpf()) != null)return new ResponseAuthDTO<UserProducerDTO>("Cpf em uso",true,null, null);
        if(userProducerRepository.findBySurname(registerProducerDTO.getSurname()) != null) return new ResponseAuthDTO<UserProducerDTO>("Surname existente",true,null, null);

        UserProducerModel userProducerModel = userMapper.registerProducerDTOToUserProducerModel(registerProducerDTO);
        String EncryptedPassword = new BCryptPasswordEncoder().encode(registerProducerDTO.getPassword());
        userProducerModel.setPassword(EncryptedPassword);
        var userProducer = userProducerRepository.save(userProducerModel);
        var usernamePassword = new UsernamePasswordAuthenticationToken(registerProducerDTO.getUsername(), registerProducerDTO.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UserModel) auth.getPrincipal());
        userProducer.setPassword(null);
        UserProducerDTO userProducerDTO = userMapper.userProducerModelToUserProducerDTO(userProducer);
        return new ResponseAuthDTO<UserProducerDTO>("registro efetuado com sucesso",false,token, userProducerDTO);
    }

    public ResponseAuthDTO<UserAdminDTO> registerUserAdmin(RegisterAdminDTO registerAdminDTO) {

        if(userRepository.findByUsername(registerAdminDTO.getUsername()) != null)return new ResponseAuthDTO<UserAdminDTO>("Username existente",true,null, null);
        if(userRepository.findByEmail(registerAdminDTO.getEmail()) != null)return new ResponseAuthDTO<UserAdminDTO>("Email em uso",true,null, null);
        if(userRepository.findByPhone(registerAdminDTO.getPhone()) != null)return new ResponseAuthDTO<UserAdminDTO>("Numero de telefone em uso",true,null, null);
        if(userRepository.findByCpf(registerAdminDTO.getCpf()) != null)return new ResponseAuthDTO<UserAdminDTO>("Cpf em uso",true,null, null);
        if(userAdminRepository.findByIdentification(registerAdminDTO.getIdentification()) != null) return new ResponseAuthDTO<UserAdminDTO>("identificaçao em uso",true,null, null);

        UserAdminModel userAdminModel = userMapper.registerAdminDTOToUserAdminModel(registerAdminDTO);
        String EncryptedPassword = new BCryptPasswordEncoder().encode(registerAdminDTO.getPassword());
        userAdminModel.setPassword(EncryptedPassword);
        var userAdmin = userAdminRepository.save(userAdminModel);
        var usernamePassword = new UsernamePasswordAuthenticationToken(registerAdminDTO.getUsername(), registerAdminDTO.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UserModel) auth.getPrincipal());
        userAdmin.setPassword(null);
        UserAdminDTO userAdminDTO = userMapper.userAdminModelToUserAdminDTO(userAdmin);
        return new ResponseAuthDTO<UserAdminDTO>("registro efetuado com sucesso",false,token, userAdminDTO);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}

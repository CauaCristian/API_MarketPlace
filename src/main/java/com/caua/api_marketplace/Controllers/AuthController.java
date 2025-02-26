package com.caua.api_marketplace.Controllers;

import com.caua.api_marketplace.DTO.Auth.LoginDTO;
import com.caua.api_marketplace.DTO.Auth.ResponseAuthDTO;
import com.caua.api_marketplace.DTO.User.UserAdminDTO;
import com.caua.api_marketplace.DTO.User.UserClientDTO;
import com.caua.api_marketplace.DTO.User.UserProducerDTO;
import com.caua.api_marketplace.Models.User.UserAdminModel;
import com.caua.api_marketplace.Models.User.UserClientModel;
import com.caua.api_marketplace.Models.User.UserProducerModel;
import com.caua.api_marketplace.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService ;

    @PostMapping("/login")
    public ResponseAuthDTO<UserDetails> login(@RequestBody LoginDTO loginDTO) {
       return authService.login(loginDTO.getUsername(), loginDTO.getPassword());
    }
    @PostMapping(value = "/registerProducer", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseAuthDTO<UserProducerModel> registerProducer(@RequestBody UserProducerDTO userProducerDTO) {
        return authService.registerUserProducer(userProducerDTO);
    }
    @PostMapping(value = "/registerClient",produces =  MediaType.APPLICATION_JSON_VALUE,consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseAuthDTO<UserClientModel> registerClient(@RequestBody UserClientDTO userClientDTO) {
        return authService.registerUserClient(userClientDTO);
    }
    @PostMapping(value = "/registerAdmin",produces =  MediaType.APPLICATION_JSON_VALUE,consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseAuthDTO<UserAdminModel> registerAdmin(@RequestBody UserAdminDTO userAdminDTO) {
        return authService.registerUserAdmin(userAdminDTO);
    }
}

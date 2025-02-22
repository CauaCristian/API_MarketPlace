package com.caua.api_marketplace.Controllers;

import com.caua.api_marketplace.DTO.Auth.LoginDTO;
import com.caua.api_marketplace.DTO.Auth.ResponseLoginDTO;
import com.caua.api_marketplace.DTO.User.UserAdminDTO;
import com.caua.api_marketplace.DTO.User.UserClientDTO;
import com.caua.api_marketplace.DTO.User.UserProducerDTO;
import com.caua.api_marketplace.Models.User.UserAdminModel;
import com.caua.api_marketplace.Models.User.UserClientModel;
import com.caua.api_marketplace.Models.User.UserProducerModel;
import com.caua.api_marketplace.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService ;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseLoginDTO login(@RequestBody LoginDTO loginDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),loginDTO.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        return new ResponseLoginDTO("login efetuado com sucesso",false,auth.toString(), authService.loadUserByUsername(loginDTO.getUsername()));
    }
    @PostMapping(value = "/registerProducer", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserProducerModel registerProducer(@RequestBody UserProducerDTO userProducerDTO) {
        return authService.registerUserProducer(userProducerDTO);
    }
    @PostMapping(value = "/registerClient",produces =  MediaType.APPLICATION_JSON_VALUE,consumes =  MediaType.APPLICATION_JSON_VALUE)
    public UserClientModel registerClient(@RequestBody UserClientDTO userClientDTO) {
        return authService.registerUserClient(userClientDTO);
    }
    @PostMapping(value = "/registerAdmin",produces =  MediaType.APPLICATION_JSON_VALUE,consumes =  MediaType.APPLICATION_JSON_VALUE)
    public UserAdminModel registerAdmin(@RequestBody UserAdminDTO userAdminDTO) {
        return authService.registerUserAdmin(userAdminDTO);
    }
}

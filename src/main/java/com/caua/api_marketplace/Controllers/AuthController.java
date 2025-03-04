package com.caua.api_marketplace.Controllers;

import com.caua.api_marketplace.DTO.Auth.*;
import com.caua.api_marketplace.DTO.User.UserAdminDTO;
import com.caua.api_marketplace.DTO.User.UserClientDTO;
import com.caua.api_marketplace.DTO.User.UserProducerDTO;
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
    public ResponseAuthDTO<Object> login(@RequestBody LoginDTO loginDTO) {
       return authService.login(loginDTO.getUsername(), loginDTO.getPassword());
    }

    @PostMapping(value = "/registerClient",produces =  MediaType.APPLICATION_JSON_VALUE,consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseAuthDTO<UserClientDTO> registerClient(@RequestBody RegisterClientDTO registerClientDTO) {
        return authService.registerUserClient(registerClientDTO);
    }

    @PostMapping(value = "/registerProducer", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseAuthDTO<UserProducerDTO> registerProducer(@RequestBody RegisterProducerDTO registerProducerDTO) {
        return authService.registerUserProducer(registerProducerDTO);
    }

    @PostMapping(value = "/registerAdmin",produces =  MediaType.APPLICATION_JSON_VALUE,consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseAuthDTO<UserAdminDTO> registerAdmin(@RequestBody RegisterAdminDTO registerAdminDTO) {
        return authService.registerUserAdmin(registerAdminDTO);
    }
}

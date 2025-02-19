package com.caua.api_marketplace.Controllers;

import com.caua.api_marketplace.DTO.User.UserAdminDTO;
import com.caua.api_marketplace.Models.User.UserAdminModel;
import com.caua.api_marketplace.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    AuthService authService ;

    @PostMapping(value = "/registerAdmin",produces =  MediaType.APPLICATION_JSON_VALUE,consumes =  MediaType.APPLICATION_JSON_VALUE)
    public UserAdminModel addAdminUser(@RequestBody UserAdminDTO userAdminDTO) {
        return authService.registerUserAdmin(userAdminDTO);
    }
}

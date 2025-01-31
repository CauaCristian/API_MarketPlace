package com.caua.api_marketplace.Controllers;

import com.caua.api_marketplace.Models.User.UserAdminModel;
import com.caua.api_marketplace.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(produces =  MediaType.APPLICATION_JSON_VALUE)
    public UserAdminModel addAdminUser() {
        return userService.createUserAdmin();
    }
}

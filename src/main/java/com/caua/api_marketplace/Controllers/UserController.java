package com.caua.api_marketplace.Controllers;
import com.caua.api_marketplace.DTO.Generic.ResponseDTO;
import com.caua.api_marketplace.DTO.User.UserAdminDTO;
import com.caua.api_marketplace.DTO.User.UserClientDTO;
import com.caua.api_marketplace.DTO.User.UserProducerDTO;
import com.caua.api_marketplace.Models.User.UserAdminModel;
import com.caua.api_marketplace.Models.User.UserClientModel;
import com.caua.api_marketplace.Models.User.UserModel;
import com.caua.api_marketplace.Models.User.UserProducerModel;
import com.caua.api_marketplace.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<List<Object>> getAll(){
        return this.userService.getAll();
    }
    @GetMapping(value="/getByUserType/{type}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<List<Object>> getByTypeUser(@PathVariable String type){
        return this.userService.getByUserType(type);
    }
    @GetMapping(value = "/getByUsername/{username}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<Object> getByUsername(@PathVariable String username){
        return this.userService.getByUsername(username);
    }
    @PutMapping(value = "/updateUserClient",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<UserClientDTO> updateUserClient(@RequestBody UserClientModel userClientModel){
        return this.userService.updateUserClient(userClientModel);
    }
    @PutMapping(value = "/updateUserProducer",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<UserProducerDTO> updateUserProducer(@RequestBody UserProducerModel userProducerModel){
        return this.userService.updateUserProducer(userProducerModel);
    }
    @PutMapping(value = "/updateUserAdmin",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<UserAdminDTO> updateUserAdmin(@RequestBody UserAdminModel userAdminModel){
        return this.userService.updateUserAdmin(userAdminModel);
    }
    @DeleteMapping(value = "/delete/{idUser}")
    public ResponseDTO<Object> deleteUser(@PathVariable Long idUser){
        return this.userService.deleteUser(idUser);
    }
}

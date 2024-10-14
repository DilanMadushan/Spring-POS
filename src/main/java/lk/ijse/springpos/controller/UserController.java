package lk.ijse.springpos.controller;

import jakarta.annotation.PostConstruct;
import lk.ijse.springpos.dto.UserDTO;
import lk.ijse.springpos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostConstruct
    public void saveUser(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId("U001");
        userDTO.setName("Dilan");
        userDTO.setPassword("123");

        userService.saveUser(userDTO);
    }

    @GetMapping(value = "{id}")
    public UserDTO findUser(@PathVariable("id")String id){
        return userService.findUser(id);
    }
}

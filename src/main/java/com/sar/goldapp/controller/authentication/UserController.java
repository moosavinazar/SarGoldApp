package com.sar.goldapp.controller.authentication;

import com.sar.goldapp.service.authentication.UserService;
import com.sar.goldapp.service.dto.authentication.UserDTO;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    public UserDTO findByUsername(String name) {
        return userService.findByUsername(name);
    }

}

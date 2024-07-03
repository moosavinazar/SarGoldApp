package com.sar.goldapp.web.rest;

import com.sar.goldapp.controller.authentication.UserController;
import com.sar.goldapp.service.dto.authentication.CreateUserDTO;
import com.sar.goldapp.service.dto.authentication.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserRestResources {

    Logger logger = LoggerFactory.getLogger(UserRestResources.class);

    private final UserController userController;

    public UserRestResources(UserController userController) {
        this.userController = userController;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() throws URISyntaxException {

        logger.info("get all users list");
        return ResponseEntity.ok(userController.findAll());

    }

    @PostMapping("/create-user")
    public ResponseEntity<Object> createUser(@RequestBody CreateUserDTO createUser) throws URISyntaxException {
        logger.info("Create user");
        if (userController.findByUsername(createUser.getCellPhone()) != null) {
            return ResponseEntity.badRequest().body("شماره موبایل قبلا در سیستم ثبت شده");
        }
        UserDTO user = userController.create(createUser);
        return ResponseEntity.created(new URI("/auth/create-user/" + user.getId())).body(user);
    }

}

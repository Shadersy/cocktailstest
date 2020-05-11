package com.gvozdilin.libraryJPA.controllers;


import com.gvozdilin.libraryJPA.dto.UserDto;
import com.gvozdilin.libraryJPA.entity.User;
import com.gvozdilin.libraryJPA.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("AllUsers")
    ResponseEntity<List<User>> all() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok().body(users);
    }


    @PostMapping(path = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto) { //создать пользователя
        userService.createUser(dto);
        logger.info("");
        return ResponseEntity.ok().build();
    }

    @GetMapping("Quantity") //получить количество взятых книга у пользователя по его id
    Long getQuantity(Long id) {
        User user = userService.findUserById(id);
        return user.getQuantity();
    }

}

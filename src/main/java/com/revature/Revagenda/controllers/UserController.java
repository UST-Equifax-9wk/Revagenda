package com.revature.Revagenda.controllers;

import com.revature.Revagenda.entities.User;
import com.revature.Revagenda.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {
    private UserService userService;

    /**
     *
     * @param userService
     */
    @Autowired //constructor injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     *
     * @param user
     * @return
     */
    @PostMapping
    User registerNewUser(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }





}

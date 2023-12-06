package com.revature.Revagenda.controllers;

import com.revature.Revagenda.entities.User;
import com.revature.Revagenda.exceptions.NoResultsException;
import com.revature.Revagenda.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RestController
public class UserController {
    private final UserService userService;

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
    @PostMapping(path = "/users")
    User registerNewUser(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }


    @GetMapping(path = "/users/{username}")
    User getUserByUsername(@PathVariable String username) throws NoResultsException {
        return userService.findByUsername(username);
    }






}

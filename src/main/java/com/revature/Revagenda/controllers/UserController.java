package com.revature.Revagenda.controllers;

import com.revature.Revagenda.entities.User;
import com.revature.Revagenda.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private UserService userService;

    @Autowired //constructor injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //a controller is a class made up of "handlers" which handle certain events when they occur, in our case HTTP requests
    //protocol:address/path/to/resource
    //http://localhost/users/getUser/5

    //URI - universal resource identifier
    //URL - universal resource locator

    /*
    CRUD - create read update delete
    get a user by username - login
    get a user by id??
    save and update user objects
    delete user objects
     */

    //POST new user - user registration
    //Http status code to inform client about success or failure
    /*
    {
        "firstName":"Kyle",
        "lastName":"Plummer",
        "username":"kplummer",
        "password":"password123"
    }
     */
    @PostMapping
    User registerNewUser(@RequestBody User user) {
        return userService.saveUser(user);
    }





}

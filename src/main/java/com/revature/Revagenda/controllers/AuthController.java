package com.revature.Revagenda.controllers;

import com.revature.Revagenda.dto.Auth;
import com.revature.Revagenda.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    //We should send back success or failure.
    //we should send back some sort of auth token - cookie


    public void authenticate(@RequestBody Auth auth) {
        //TODO: finish this method
    }


}

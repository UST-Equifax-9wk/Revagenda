package com.revature.Revagenda.controllers;

import com.revature.Revagenda.dto.Auth;
import com.revature.Revagenda.services.AuthService;
import com.revature.Revagenda.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    private final UserService userService;
    private final AuthService authService;

    @Autowired
    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    //We should send back success or failure.
    //we should send back some sort of auth token - cookie


    public void authenticate(@RequestBody Auth auth) {
        //TODO: finish this method
    }

    @GetMapping(path = "/cookie-test")
    @ResponseStatus(HttpStatus.OK)
    public String testCookie(@CookieValue(name = "username") String username, @CookieValue(name = "hash") String hash) {//get cookie from request
        if(authService.checkHash(username, hash)) {
            System.out.println("Auth cookie verified!");
            return "Auth cookie verified!";
        } else {
            System.out.println("Failed to authenticate");
            return "Failed to authenticate";
        }
    }

    @PostMapping(path = "/cookie-test")
    @ResponseStatus(HttpStatus.OK)
    public String testCookieGenerate(HttpServletResponse response) {
        //pretend we have completed authenticating a user here, we got a username and pass and they matched...
        String username = "kplummer";
        Cookie auth = new Cookie("username", username);
        response.addCookie(auth);
        Cookie hash = new Cookie("hash", authService.hash(username));
        response.addCookie(hash);
        return "Cookies added";
    }


}

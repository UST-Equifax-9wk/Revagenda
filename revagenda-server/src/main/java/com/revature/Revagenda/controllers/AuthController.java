package com.revature.Revagenda.controllers;

import com.revature.Revagenda.dto.NewUserDto;
import com.revature.Revagenda.entities.Auth;
import com.revature.Revagenda.entities.User;
import com.revature.Revagenda.exceptions.AccessDeniedException;
import com.revature.Revagenda.exceptions.NoResultsException;
import com.revature.Revagenda.exceptions.UsernameUnavailableException;
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

    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User registerUser(@RequestBody NewUserDto newUserDto, HttpServletResponse response) throws UsernameUnavailableException{
        return authService.registerUser(newUserDto);
    }

    @PostMapping(path = "/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User authenticate(@RequestBody Auth auth, HttpServletResponse response) throws AccessDeniedException {
        if(this.authService.authenticate(auth)){
            try {
                return userService.findByUsername(auth.getUsername());
            } catch (NoResultsException e) {
                throw new AccessDeniedException("Access denied");
            }
        } else {
            throw new AccessDeniedException("Access denied");
        }
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

    @PostMapping(path = "/cookie-test/{username}")
    @ResponseStatus(HttpStatus.OK)
    public String testCookieGenerate(HttpServletResponse response, @PathVariable String username) {
        //pretend we have completed authenticating a user here, we got a username and pass and they matched...
        Cookie auth = new Cookie("username", username);
        response.addCookie(auth);
        Cookie hash = new Cookie("hash", authService.hash(username));
        response.addCookie(hash);
        return "Cookies added";
    }

    @ExceptionHandler(UsernameUnavailableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String usernameUnavailableExceptionHandler() {
        return "This username is unavailable";
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String accessDeniedExceptionHandler() {
        return "Access denied";
    }


}

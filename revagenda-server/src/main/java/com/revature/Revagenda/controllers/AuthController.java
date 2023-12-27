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
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
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
                Cookie cookie = new Cookie("username", auth.getUsername());
                cookie.setMaxAge(60*60*24*7);
                cookie.setPath("/");
                response.addCookie(cookie);
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
    public User testCookie(@CookieValue(name = "username") String username) {//get cookie from request
        System.out.println("cookie username: " + username);
        return new User();
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

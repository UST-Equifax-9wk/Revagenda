package com.revature.Revagenda.controllers;

import com.revature.Revagenda.entities.User;
import com.revature.Revagenda.exceptions.NoResultsException;
import com.revature.Revagenda.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RestController
@CrossOrigin
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
    @ResponseStatus(HttpStatus.OK)
    User registerNewUser(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }


    @GetMapping(path = "/users/{username}")
    @ResponseStatus(HttpStatus.OK)
    User getUserByUsername(@PathVariable String username) throws NoResultsException {
        return userService.findByUsername(username);
    }

    /**
     * Take in user object from request body and update existing records in database
     * @param user - User object de-serialized from JSON representation in body
     */
    @PutMapping(path = "/users")
    void updateUser(@RequestBody User user) {
        //TODO: Finish this method
    }

    @DeleteMapping(path = "/users/{userId}")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    void deleteUser(@PathVariable Integer userId) {
        //TODO: Finish this method
    }

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<String> internalErrorHandler(NoResultsException e) {
//        ResponseEntity<String> resp = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        return resp;
//    }


//    @ExceptionHandler(NoResultsException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String noResultsExceptionHandler(NoResultsException e) {
//        return "<!DOCTYPE html>\n" +
//                "<html lang=\"en\">\n" +
//                "<head>\n" +
//                "    <meta charset=\"UTF-8\">\n" +
//                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
//                "    <title>Error Page</title>\n" +
//                "</head>\n" +
//                "<body>\n" +
//                "    <h1>Error, no results found!</h1>\n" +
//                "    <img src=\"https://upload.wikimedia.org/wikipedia/commons/f/f7/Generic_error_message.png\">\n" +
//                "</body>\n" +
//                "</html>";
//    }



}

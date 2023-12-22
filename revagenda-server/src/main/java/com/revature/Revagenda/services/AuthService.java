package com.revature.Revagenda.services;


import com.revature.Revagenda.dto.NewUserDto;
import com.revature.Revagenda.entities.Auth;
import com.revature.Revagenda.entities.User;
import com.revature.Revagenda.exceptions.UsernameUnavailableException;
import com.revature.Revagenda.repositories.AuthRepository;
import jakarta.transaction.Transactional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private UserService userService;
    private AuthRepository authRepository;

    @Autowired
    public AuthService(UserService userService, AuthRepository authRepository) {
        this.userService = userService;
        this.authRepository = authRepository;
    }


    @Transactional
    public User registerUser(NewUserDto newUser) throws UsernameUnavailableException {
        if(!this.userService.checkUsername(newUser.getUser().getUsername())) {
            newUser.getAuth().setPassword(this.hash(newUser.getAuth().getPassword()));
            this.authRepository.save(newUser.getAuth());
            return this.userService.saveOrUpdate(newUser.getUser());
        }
        throw new UsernameUnavailableException("This username is not available");
    }

    public boolean authenticate(Auth auth) {
        Optional<Auth> candidate = this.authRepository.findByUsername(auth.getUsername());
        if(candidate.isPresent()) {
            return this.checkHash(auth.getPassword(), candidate.get().getPassword());
        } else {
            return false;
        }
    }

    public String hash(String text) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(text, salt);
    }

    public boolean checkHash(String text, String hash) {
        return BCrypt.checkpw(text, hash);
    }
}

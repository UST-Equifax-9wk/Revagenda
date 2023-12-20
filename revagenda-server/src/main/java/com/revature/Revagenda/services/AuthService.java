package com.revature.Revagenda.services;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public String hash(String text) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(text, salt);
    }

    public boolean checkHash(String text, String hash) {
        return BCrypt.checkpw(text, hash);
    }
}

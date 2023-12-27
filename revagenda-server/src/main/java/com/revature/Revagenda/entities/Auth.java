package com.revature.Revagenda.entities;

import jakarta.persistence.*;

@Entity(name = "passwords")
@Table(/*indexes = {@Index(columnList = "username")}*/)
public class Auth {
    @Id
    @Column(name = "username")
    private String username;

    @Column
    private String password;

    public Auth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Auth() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

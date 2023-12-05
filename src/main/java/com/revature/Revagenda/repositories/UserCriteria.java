package com.revature.Revagenda.repositories;

import com.revature.Revagenda.entities.User;

import java.util.List;

public interface UserCriteria {
    List<User> findUsersByFirstName(String firstName);
}

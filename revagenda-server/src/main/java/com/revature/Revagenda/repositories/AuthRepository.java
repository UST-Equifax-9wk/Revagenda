package com.revature.Revagenda.repositories;

import com.revature.Revagenda.entities.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Integer> {
    Auth findByUsername(String username);
}

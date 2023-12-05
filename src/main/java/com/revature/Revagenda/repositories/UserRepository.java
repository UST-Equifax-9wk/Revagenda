package com.revature.Revagenda.repositories;

import com.revature.Revagenda.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserCriteria {

    Optional<User> findByUsername(String username);

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE last_name LIKE CONCAT(?1, '%') ORDER BY first_name LIMIT 1")
    Optional<User> findUserWhereLastNameStartsWithChar(char c);

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE last_name LIKE CONCAT(?1, '%')")
    List<User> findUsersWhereLastNameStartsWithChar(char c);



}

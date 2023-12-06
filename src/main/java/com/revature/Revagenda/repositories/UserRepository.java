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
    Optional<User> findById(Integer id);
    //void save(User user);
    //void delete(Integer id);
    void delete(User user);



    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE last_name LIKE CONCAT(?1, '%') ORDER BY first_name LIMIT 1")
    Optional<User> findUserWhereLastNameStartsWithChar(char c);

    @Query(nativeQuery = true, value = "SELECT u.user_id, u.first_name, u.last_name, u.username, u.password, t.task_id, t.description, t.due, t.title FROM users u FULL JOIN tasks t ON u.user_id = t.user_id WHERE u.last_name LIKE CONCAT(?1, '%')")
    List<User> findUsersWhereLastNameStartsWithChar(char c);



}

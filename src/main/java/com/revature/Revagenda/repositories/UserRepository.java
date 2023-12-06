package com.revature.Revagenda.repositories;

import com.revature.Revagenda.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    /*
    DB operations to expose to the services(CRUD operations):
    find user by username - Optional<User> findByUsername(String username);
    find user by user id - Optional<User> findById(Integer id); built-in, no need to name it.
    save/update user - void save(User user); built-in, no need to name it.
    delete user by id - void deleteById(Integer id); built-in, no need to name it.
    delete user by user object - void delete(User user); built-in, no need to name it.
     */

    /**
     *
     * @param username
     * @return
     */
    Optional<User> findByUsername(String username); //this one gets built based on its name by Spring doing Reflection

    /*
    //These were for demo purposes, and are now deprecated.
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE last_name LIKE CONCAT(?1, '%') ORDER BY first_name LIMIT 1")
    Optional<User> findUserWhereLastNameStartsWithChar(char c);

    @Query(nativeQuery = true, value = "SELECT u.user_id, u.first_name, u.last_name, u.username, u.password, t.task_id, t.description, t.due, t.title FROM users u FULL JOIN tasks t ON u.user_id = t.user_id WHERE u.last_name LIKE CONCAT(?1, '%')")
    List<User> findUsersWhereLastNameStartsWithChar(char c);
    */


}

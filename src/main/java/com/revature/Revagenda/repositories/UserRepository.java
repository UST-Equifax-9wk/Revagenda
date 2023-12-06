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

}

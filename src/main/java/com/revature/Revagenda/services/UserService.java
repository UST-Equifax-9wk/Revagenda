package com.revature.Revagenda.services;

import com.revature.Revagenda.entities.Task;
import com.revature.Revagenda.entities.User;
import com.revature.Revagenda.exceptions.NoResultsException;
import com.revature.Revagenda.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Set;

/**
 *
 */
@Service
@Transactional(Transactional.TxType.REQUIRED)//propagation
public class UserService {
    private final UserRepository userRepository;
    private final TaskService taskService;

    /**
     *
     * @param userRepository
     * @param taskService
     */
    @Autowired
    public UserService(UserRepository userRepository, TaskService taskService) {
        this.userRepository = userRepository;
        this.taskService = taskService;
    }

    /**
     *
     * @param username
     * @return
     * @throws NoResultsException
     */
    public User findUserAndTasks(String username) throws NoResultsException {
        User user = this.findByUsername(username);
        Set<Task> tasks = taskService.findAllTasksForUser(user);
        user.setTasks(tasks);
        return user;
    }


    /**
     *
     * @param username
     * @return
     * @throws NoResultsException
     */
    public User findByUsername(String username) throws NoResultsException {
        Optional<User> result = userRepository.findByUsername(username);
        if (result.isEmpty()) {
            throw new NoResultsException("No results for username: " + username);
        }
        return result.get();
    }

    /**
     *
     * @param id
     * @return
     * @throws NoResultsException
     */
    public User findByUserId(Integer id) throws NoResultsException {
        Optional<User> result = userRepository.findById(id);
        if (result.isEmpty()) {
            throw new NoResultsException("No users found with ID: " + id);
        }
        return result.get();
    }

    /**
     *
     * @param user
     * @return
     */
    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

    /**
     *
     * @param user
     */
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    /**
     *
     * @param id
     */
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }


}

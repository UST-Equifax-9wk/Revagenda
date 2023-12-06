package com.revature.Revagenda.services;

import com.revature.Revagenda.entities.Task;
import com.revature.Revagenda.entities.User;
import com.revature.Revagenda.exceptions.NoResultsException;
import com.revature.Revagenda.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional(Transactional.TxType.REQUIRED)//propagation
public class UserService {
    private UserRepository repo;
    private TaskService taskService;

    @Autowired
    public UserService(UserRepository repo, TaskService taskService) {
        this.repo = repo;
        this.taskService = taskService;
    }

    public User findUserAndTasks(String username) throws NoResultsException {
        User user = this.findUserByUsername(username);
        Set<Task> tasks = taskService.findAllTasksForUser(user);
        user.setTasks(tasks);
        return user;
    }


    //for whatever reason we want this type of method to behave differently. This annotation supersedes the one at the top of the class
    public User findUserByUsername(String username) throws NoResultsException {
        Optional<User> result = repo.findByUsername(username);
        if (result.isEmpty()) {
            throw new NoResultsException("No results for username: " + username);
        }
        return result.get();
    }

    public User findByUserId(Integer id) throws NoResultsException {
        Optional<User> result = repo.findById(id);
        if (result.isEmpty()) {
            throw new NoResultsException("No users found with ID: " + id);
        }
        return result.get();
    }

    public User saveUser(User user) {
        return repo.save(user);
    }

    public void saveUsers(List<User> users) {
        for (User user : users) {
            repo.save(user);
        }
    }

    public void deleteUser(User user) {
        repo.delete(user);
    }

    public void deleteUser(Integer id) {
        repo.deleteById(id);
    }



    /*
    These are not really important for our workflows, just for demonstration purposes
     */
    public List<User> findUsersByFirstName(String name) throws NoResultsException {
        List<User> results = repo.findUsersByFirstName(name);
        if (results.isEmpty()) {
            throw new NoResultsException("Query returned no results for name: " + name);
        }
        return results;
    }

    public User findUserByLastInitial(char c) throws NoResultsException {
        Optional<User> result = repo.findUserWhereLastNameStartsWithChar(c);
        if (result.isEmpty()) {
            throw new NoResultsException("No users with last initial: " + c);
        }
        return result.get();
    }

    public List<User> findUsersByLastInitial(char c) throws NoResultsException {
        List<User> results = repo.findUsersWhereLastNameStartsWithChar(c);
        if (results.isEmpty()) {
            throw new NoResultsException("No users with last initial: " + c);
        }
        return results;
    }
}

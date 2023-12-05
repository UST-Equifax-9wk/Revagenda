package com.revature.Revagenda.services;

import com.revature.Revagenda.entities.User;
import com.revature.Revagenda.exceptions.NoResultsException;
import com.revature.Revagenda.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(Transactional.TxType.REQUIRED)//isolation, propagation
public class UserService {
    private UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> findUsersByFirstName(String name) throws NoResultsException {
        List<User> results = repo.findUsersByFirstName(name);
        if(results.isEmpty()){
            throw new NoResultsException("Query returned no results for name: " + name);
        }
        return results;
    }

    @Transactional(Transactional.TxType.SUPPORTS)//for whatever reason we want this type of method to behave differently. This annotation supersedes the one at the top of the class
    public User findUserByUsername(String username) throws NoResultsException{
        Optional<User> result = repo.findByUsername(username);
        if(result.isEmpty()) {
            throw new NoResultsException("No results for username: " + username);
        }
        return result.get();
    }

    public User findUserByLastInitial(char c) throws NoResultsException {
        Optional<User> result = repo.findUserWhereLastNameStartsWithChar(c);
        if(result.isEmpty()) {
            throw new NoResultsException("No users with last initial: " + c);
        }
        return result.get();
    }

    public List<User> findUsersByLastInitial(char c) throws NoResultsException {
        List<User> results = repo.findUsersWhereLastNameStartsWithChar(c);
        if(results.isEmpty()) {
            throw new NoResultsException("No users with last initial: " + c);
        }
        return results;
    }

    public User findByUserId(int id) throws NoResultsException {
        Optional<User> result = repo.findById(id);
        if(result.isEmpty()) {
            throw new NoResultsException("No users found with ID: " + id);
        }
        return result.get();
    }

    public void saveUser(User user) {
        repo.save(user);
    }

    public void saveUsers(List<User> users) {
        for (User user : users) {
            repo.save(user);
        }
    }

    public void deleteUser(User user) {
        repo.delete(user);
    }

    public void deleteUser(int id) {
        repo.deleteById(id);
    }



}

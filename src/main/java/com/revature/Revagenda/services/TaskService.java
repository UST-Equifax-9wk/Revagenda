package com.revature.Revagenda.services;

import com.revature.Revagenda.entities.Task;
import com.revature.Revagenda.entities.User;
import com.revature.Revagenda.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class TaskService {
    private TaskRepository repo;

    @Autowired
    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    //create and update
    public void saveOrUpdate(Task task) {
        repo.save(task);
    }

    public void saveOrUpdate(Set<Task> taskSet) {
        for(Task task : taskSet) {
            repo.save(task);
        }
    }

    //find all tasks for user
    public Set<Task> findAllTasksForUser(Integer userId) {
        return repo.findTasksByUserUserId(userId);
    }

    public Set<Task> findAllTasksForUser(User user) {
        return repo.findTasksByUserUserId(user.getUserId());
    }

    public void delete(Integer taskId) {
        repo.deleteById(taskId);
    }

    public void delete(Task task) {
        repo.delete(task);
    }

}

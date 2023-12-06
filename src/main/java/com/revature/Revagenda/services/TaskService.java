package com.revature.Revagenda.services;

import com.revature.Revagenda.entities.Task;
import com.revature.Revagenda.entities.User;
import com.revature.Revagenda.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

/**
 *
 */
@Service
@Transactional(Transactional.TxType.REQUIRED)
public class TaskService {
    private TaskRepository repo;

    /**
     *
     * @param repo
     */
    @Autowired
    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    /**
     *
     * @param task
     */
    public void saveOrUpdate(Task task) {
        repo.save(task);
    }

    /**
     *
     * @param taskSet
     */
    public void saveOrUpdate(Set<Task> taskSet) {
        for(Task task : taskSet) {
            repo.save(task);
        }
    }

    /**
     *
     * @param userId
     * @return
     */
    public Set<Task> findAllTasksForUser(Integer userId) {
        return repo.findTasksByUserUserId(userId);
    }

    /**
     *
     * @param user
     * @return
     */
    public Set<Task> findAllTasksForUser(User user) {
        return repo.findTasksByUserUserId(user.getUserId());
    }

    /**
     *
     * @param taskId
     */
    public void delete(Integer taskId) {
        repo.deleteById(taskId);
    }

    /**
     *
     * @param task
     */
    public void delete(Task task) {
        repo.delete(task);
    }

}

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
    private TaskRepository taskRepository;

    /**
     * Constructor
     * @param taskRepository - autowired TaskRepository bean dependency
     */
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     *
     * @param task
     */
    public Task saveOrUpdate(Task task) {
        return taskRepository.save(task);
    }

    /**
     *
     * @param taskSet
     */
    public void saveOrUpdate(Set<Task> taskSet) {
        for(Task task : taskSet) {
            taskRepository.save(task);
        }
    }

    /**
     *
     * @param userId
     * @return
     */
    public Set<Task> findAllTasksForUser(Integer userId) {
        return taskRepository.findTasksByUserUserId(userId);
    }

    /**
     *
     * @param user
     * @return
     */
    public Set<Task> findAllTasksForUser(User user) {
        return taskRepository.findTasksByUserUserId(user.getUserId());
    }

    /**
     *
     * @param taskId
     */
    public void delete(Integer taskId) {
        taskRepository.deleteById(taskId);
    }

    /**
     *
     * @param task
     */
    public void delete(Task task) {
        taskRepository.delete(task);
    }

}

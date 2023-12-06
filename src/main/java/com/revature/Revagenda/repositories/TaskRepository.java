package com.revature.Revagenda.repositories;

import com.revature.Revagenda.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    //expose CRUD functionality
    //Create(update), Read, Delete
    //find tasks by user id
    //create/update - save()
    //delete - same as user, delete by id or obj
    Set<Task> findTasksByUserUserId(Integer userId);
    //void deleteById(Integer taskId);
    void delete(Task task);
}

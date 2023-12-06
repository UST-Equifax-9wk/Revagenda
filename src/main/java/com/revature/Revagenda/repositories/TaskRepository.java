package com.revature.Revagenda.repositories;

import com.revature.Revagenda.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

/**
 *
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    /*
    DB operations to expose to the services(CRUD operations):
    find tasks by user id - Set<Task> findTasksByUserUserId(Integer userId); - note how "User" appears twice in method name
    save or update tasks - Task save(Task task); - built-in
    delete by id - void deleteById(Integer taskId); - built-in
    delete by object - void delete(Task task); - built-in
     */

    Set<Task> findTasksByUserUserId(Integer userId);
}

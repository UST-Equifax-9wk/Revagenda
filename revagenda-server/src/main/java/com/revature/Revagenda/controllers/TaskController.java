package com.revature.Revagenda.controllers;

import com.revature.Revagenda.entities.Task;
import com.revature.Revagenda.entities.User;
import com.revature.Revagenda.exceptions.NoResultsException;
import com.revature.Revagenda.services.TaskService;
import com.revature.Revagenda.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * This controller handles task associated requests, exposing CRUD functionality to complete workflows
 * such as saving or retrieving tasks.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    /**
     * This method exposes create functionality on Task items, persisting them in the database. Username is used
     * to identify the user who owns the task.
     * @param username - String representing the unique username
     * @param task - Task object to be saved
     * @return - Task object with auto-generated keys and other references in place
     * @throws NoResultsException when the username isn't matched in the database
     */
    @PostMapping(path = "/users/{username}/tasks")
    public Task createNewTask(@PathVariable String username, @RequestBody Task task) throws NoResultsException {

        User user = userService.findByUsername(username);
        task.setUser(user);
        return taskService.save(task, username);

    }


    /**
     * This method queries the database for tasks belonging to a specific user and allows
     * client to filter tasks based on complete being true or false. Complete parameter should
     * be included in the query list of the request.
     * @param username - String identifying the user who owns the tasks
     * @param complete - boolean filter criteria for tasks
     * @return a List of task items
     * @throws NoResultsException when the username doesn't match any in the database
     */
    @GetMapping(path = "/users/{username}/tasks")
    public List<Task> getTasksForUserByCompletionStatus(@PathVariable String username, @RequestParam String complete) throws NoResultsException {
        User user = userService.findByUsername(username);
        Set<Task> tasks = taskService.findAllTasksForUser(user);
        boolean query = Boolean.parseBoolean(complete);
        return tasks.stream().filter(t -> t.isComplete() == query).toList();
    }





}

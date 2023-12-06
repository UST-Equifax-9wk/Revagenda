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
import java.util.stream.Collectors;

/**
 *
 */
@RestController
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @PostMapping(path = "/users/{username}/tasks")
    public Task createNewTask(@PathVariable String username, @RequestBody Task task) throws NoResultsException {
        User user = userService.findByUsername(username);
        task.setUser(user);
        return taskService.saveOrUpdate(task);

    }



    @GetMapping(path = "/users/{username}/tasks")
    public List<Task> getIncompleteTasksForUser(@PathVariable String username, @RequestParam String complete) throws NoResultsException {
        User user = userService.findByUsername(username);
        Set<Task> tasks = taskService.findAllTasksForUser(user);
        boolean query = Boolean.parseBoolean(complete);
        return tasks.stream().filter(t -> t.isComplete() == query).toList();
    }



}

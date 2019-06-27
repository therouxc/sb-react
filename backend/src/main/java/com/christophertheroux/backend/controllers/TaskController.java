package com.christophertheroux.backend.controllers;

import com.christophertheroux.backend.data.Task;
import com.christophertheroux.backend.data.TaskDto;
import com.christophertheroux.backend.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/task/random", method = RequestMethod.GET)
    public Task getRandomTask() {
        Task task = new Task();
        task.setName("Task1");
        task.setDescription("This is a task!");
        return task;
    }

    @RequestMapping(value = "/createTask", method = RequestMethod.PUT)
    public void createTask(@RequestBody TaskDto taskDto) {
        taskService.createTask(taskDto);
    }

    @RequestMapping(value = "/deleteTask/{taskId}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable("taskId") long taskId) {
        taskService.deleteTaskById(taskId);
    }

    @RequestMapping(value = "/getTask/{taskId}", method = RequestMethod.GET)
    public TaskDto getTaskById(@PathVariable("taskId") long taskId) {
        return taskService.getTaskById(taskId);
    }

    @RequestMapping(value = "/getAllTasks", method = RequestMethod.GET)
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @RequestMapping(value = "/deleteTaskByName/{taskName}", method = RequestMethod.DELETE)
    public void deleteTaskByName(@PathVariable("taskName") String taskName) {
        taskService.deleteTaskByName(taskName);
    }
}

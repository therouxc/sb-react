package com.christophertheroux.backend.services;

import com.christophertheroux.backend.data.Task;
import com.christophertheroux.backend.data.TaskDto;
import com.christophertheroux.backend.repos.TaskRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private static final Logger LOG = LogManager.getLogger(TaskService.class);

    @Autowired
    TaskRepository taskRepository;

    public void createTask(TaskDto taskDto) {
        LOG.info("Creating task: " + taskDto);
        Task task = new Task(taskDto);
        taskRepository.save(task);
    }

    public void deleteTaskById(long taskId) {
        taskRepository.deleteById(taskId);
    }

    public TaskDto getTaskById(long taskId) {
        Task task = taskRepository.getOne(taskId);

        return convertToDto(task);
    }

    public ArrayList<TaskDto> getAllTasks() {
        LOG.info("Getting all tasks");

        List<Task> tasks = taskRepository.findAll();
        ArrayList<TaskDto> taskDtos = new ArrayList<>();
        for (Task task: tasks) {
            taskDtos.add(convertToDto(task));
        }

        return taskDtos;
    }

    public void deleteTaskByName(String taskName) {
        taskRepository.deleteByName(taskName);
    }

    private TaskDto convertToDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setName(task.getName());
        taskDto.setDescription(task.getDescription());
        taskDto.setId(task.getId());
        taskDto.setComplete(task.isComplete());

        return taskDto;
    }
}

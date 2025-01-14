package com.example.tasktracker.service;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public boolean addTask(Task task, Errors errors) {
        if (errors.hasErrors()) {
            return false;
        }
        taskRepository.save(task);
        return true;
    }
}

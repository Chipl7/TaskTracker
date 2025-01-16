package com.example.tasktracker.contollers;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.repository.TaskRepository;
import com.example.tasktracker.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task")
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/task/{id}")
    public Task findById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @PostMapping("/task")
    public void newTask(@RequestBody Task newTask) {
        taskService.save(newTask);
    }

    @PutMapping("/task/{id}")
    public Optional<Task> update(@RequestBody Task task, @PathVariable Long id) {
        return taskService.update(task, id);
    }

    @DeleteMapping("/task/{id}")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}

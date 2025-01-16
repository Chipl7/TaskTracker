package com.example.tasktracker.service;

import com.example.tasktracker.excption.TaskNotFoundException;
import com.example.tasktracker.model.Task;
import com.example.tasktracker.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Optional<Task> update(Task newTask, Long id) {
        return taskRepository.
                findById(id).map(task -> {
                    task.setName(newTask.getName());
                    task.setDescriptions(newTask.getDescriptions());
                    return taskRepository.save(task);
                });
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

}

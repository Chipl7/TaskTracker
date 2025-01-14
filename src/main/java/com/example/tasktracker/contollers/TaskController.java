package com.example.tasktracker.contollers;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.model.TasksList;
import com.example.tasktracker.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
@SessionAttributes("tasksList")
public class TaskController {
    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/add")
    public String addTask(Model model) {
        return "addTask";
    }

    @ModelAttribute(name = "task")
    public Task task() {
        return new Task();
    }

    @PostMapping
    public String processTask(@Valid Task task, Errors errors, @ModelAttribute TasksList tasksList) {
        if (errors.hasErrors()) {
            return "addTask";
        }
        taskRepository.save(task);
        tasksList.addTask(task);
        return "redirect:/";
    }
}

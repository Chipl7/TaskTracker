package com.example.tasktracker.contollers;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.model.TasksList;
import com.example.tasktracker.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
@SessionAttributes("tasksList")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
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
        if (taskService.addTask(task, errors) == false) {
            return "addTask";
        }
        tasksList.addTask(task);
        return "redirect:/";
    }
}

package com.example.tasktracker.contollers;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private TaskService taskService;

    public HomeController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("taskList", taskService.findAll());
        model.addAttribute("task", new Task());
        return "home";
    }

    @PostMapping
    public String processTask(@ModelAttribute @Valid Task task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "home";
        }
        taskService.save(task);
        return "redirect:/";
    }
}

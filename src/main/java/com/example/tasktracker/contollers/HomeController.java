package com.example.tasktracker.contollers;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.model.TasksList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

//    @ModelAttribute(name = "task")
//    public Task task() {
//        return new Task();
//    }

    @ModelAttribute(name = "tasksList")
    public TasksList tasksList() {
        return new TasksList();
    }

    @PostMapping
    public String processTask(@ModelAttribute TasksList tasksList) {
        return "redirect:/task/add";
    }
}

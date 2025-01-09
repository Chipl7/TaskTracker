package com.example.tasktracker.contollers;

import com.example.tasktracker.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/task")
@SessionAttributes("taskList")
public class TaskController {

    @GetMapping("/add")
    public String addTask() {
        return "addTask";
    }

    @ModelAttribute(name = "task")
    public Task task() {
        return new Task();
    }
}

package com.example.tasktracker.contollers;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.model.TasksList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/task")
@SessionAttributes("taskList")
public class TaskController {

    @GetMapping("/add")
    public String addTask(Model model) {
        return "addTask";
    }

    @ModelAttribute(name = "task")
    public Task task() {
        return new Task();
    }

    @PostMapping
    public String processTask(Task task, TasksList tasksList, SessionStatus sessionStatus) {
        tasksList.addTask(task);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}

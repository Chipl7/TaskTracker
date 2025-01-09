package com.example.tasktracker.model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TasksList {

    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        this.tasks.add(task);
    }
}

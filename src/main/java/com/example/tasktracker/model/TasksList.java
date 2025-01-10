package com.example.tasktracker.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data //TODO
public class TasksList {

    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}

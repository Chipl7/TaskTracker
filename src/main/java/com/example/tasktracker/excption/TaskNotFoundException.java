package com.example.tasktracker.excption;

public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(Long id) {
        super("Cloud not find employee " + id);
    }
}

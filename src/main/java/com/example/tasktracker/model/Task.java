package com.example.tasktracker.model;


import lombok.Data;

import java.util.Date;

@Data
public class Task {

    private Long id;

    private Date createdAt = new Date();

    private String name;

    private String descriptions;
}

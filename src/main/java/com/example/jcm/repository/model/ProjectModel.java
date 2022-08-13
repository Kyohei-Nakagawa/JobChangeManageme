package com.example.jcm.repository.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ProjectModel {

    private int id;
    private String status;
    private String agent;
    private String company;
    private String title;
    private String programming;
    private String detail;
    private Timestamp uptime;
    private Timestamp register;
}

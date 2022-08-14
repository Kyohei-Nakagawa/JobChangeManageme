package com.example.jcm.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ProjectEntity {

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

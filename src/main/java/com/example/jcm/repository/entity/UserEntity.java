package com.example.jcm.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class UserEntity {

    private int id;
    private String mail;
    private String password;
    private String agent;
    private String company;
    private Authority authority;
    private Timestamp register;

    public enum Authority {
        OWNER,
        AGENT,
        USER
    }
}

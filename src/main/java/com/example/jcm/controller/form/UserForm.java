package com.example.jcm.controller.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserForm {

    @NotBlank
    @Size(max = 256)
    private String mail;

    @NotBlank
    @Size(min = 12, max = 128)
    private String password;

    @NotBlank
    @Size(max = 256)
    private String agent;

    @Size(max = 256)
    private String company;

    @NotBlank
    private String authority;
}

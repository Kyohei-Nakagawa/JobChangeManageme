package com.example.jcm.controller.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ProjectForm {

    @NotBlank
    private String status;

    @NotBlank
    private String agent;

    @NotBlank
    @Size(max=256)
    private String company;

    @NotBlank
    @Size(max=512)
    private String title;

    @Size(max=64)
    private String programming;

    @NotBlank
    private String detail;
}

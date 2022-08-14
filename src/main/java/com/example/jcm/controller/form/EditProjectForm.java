package com.example.jcm.controller.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EditProjectForm {

    @NotBlank
    private String statusEdit;

    @NotBlank
    private String detailEdit;
}

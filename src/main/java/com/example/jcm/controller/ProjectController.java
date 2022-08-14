package com.example.jcm.controller;

import com.example.jcm.controller.form.ProjectForm;
import com.example.jcm.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("projectList", projectService.findAll());
        return "projects/list";
    }

    @PostMapping
    public String addProject(@Validated ProjectForm form, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return showAddForm(form);
        }
        projectService.addProject(form.getStatus(), form.getAgent(), form.getCompany(), form.getTitle(), form.getProgramming(), form.getDetail());
        return "redirect:/projects";
    }

    @GetMapping("/addForm")
    public String showAddForm(@ModelAttribute ProjectForm form) {
        return "projects/addForm";
    }

    @GetMapping("/{projectId}")
    public String showDetail(@PathVariable("projectId") long projectId, Model model) {
        model.addAttribute("project", projectService.findById(projectId));
        return "projects/detail";
    }
}

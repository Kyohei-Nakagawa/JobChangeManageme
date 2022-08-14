package com.example.jcm.controller;

import com.example.jcm.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/addForm")
    public String showAddForm() {
        return "projects/addForm";
    }

    @GetMapping("/{projectId}")
    public String showDetail(@PathVariable("projectId") long projectId, Model model) {
        model.addAttribute("project", projectService.findById(projectId));
        return "projects/detail";
    }
}

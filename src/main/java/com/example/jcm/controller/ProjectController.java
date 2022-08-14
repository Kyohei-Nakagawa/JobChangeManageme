package com.example.jcm.controller;

import com.example.jcm.controller.form.EditProjectForm;
import com.example.jcm.controller.form.ProjectForm;
import com.example.jcm.controller.form.SelectOption;
import com.example.jcm.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final List<SelectOption> statusList = Arrays.asList(
            new SelectOption("screen", "書類選考"),
            new SelectOption("interview", "面談"),
            new SelectOption("waiting", "結果待ち"),
            new SelectOption("pass", "内定"),
            new SelectOption("failure", "不採用"));
    private final List<SelectOption> agentList = Arrays.asList(
            new SelectOption("geechs", "ギークス"),
            new SelectOption("pebank", "PE-BANK"),
            new SelectOption("techfree", "テクフリ"),
            new SelectOption("levtech", "レバテック"),
            new SelectOption("typeagent", "タイプ"));

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("projectList", projectService.findAll());
        return "projects/list";
    }

    @PostMapping
    public String addProject(@Validated ProjectForm form, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return showAddForm(form, model);
        }
        projectService.addProject(form.getStatus(), form.getAgent(), form.getCompany(), form.getTitle(), form.getProgramming(), form.getDetail());
        return "redirect:/projects";
    }

    @PostMapping("/{projectId}")
    public String editProject(@PathVariable("projectId") int projectId, @Validated EditProjectForm form, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return showEditForm(projectId, form, model);
        }
        projectService.editProject(projectId, form.getStatusEdit(), form.getDetailEdit());
        return "redirect:/projects/" + String.valueOf(projectId);
    }

    @GetMapping("/addForm")
    public String showAddForm(@ModelAttribute ProjectForm form, Model model) {
        model.addAttribute("statusList", statusList);
        model.addAttribute("agentList", agentList);
        return "projects/addForm";
    }

    @GetMapping("/editForm/{projectId}")
    public String showEditForm(@PathVariable("projectId") int projectId, @ModelAttribute EditProjectForm form, Model model) {
        model.addAttribute("project", projectService.findById(projectId));
        model.addAttribute("statusList", statusList);
        model.addAttribute("agentList", agentList);
        return "projects/editForm";
    }

    @GetMapping("/{projectId}")
    public String showDetail(@PathVariable("projectId") int projectId, Model model) {
        model.addAttribute("project", projectService.findById(projectId));
        return "projects/detail";
    }
}

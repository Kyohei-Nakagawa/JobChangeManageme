package com.example.jcm.controller;

import com.example.jcm.controller.form.UserForm;
import com.example.jcm.controller.form.SelectOption;
import com.example.jcm.service.ProjectService;
import com.example.jcm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;
    public final ProjectService projectService;

    private final List<SelectOption> agentList = Arrays.asList(
            new SelectOption("geechs", "ギークス"),
            new SelectOption("pebank", "PE-BANK"),
            new SelectOption("techfree", "テクフリ"),
            new SelectOption("levtech", "レバテック"),
            new SelectOption("typeagent", "タイプ"));

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "users/list";
    }

    @GetMapping("/createForm")
    public String showCreateForm(@ModelAttribute UserForm userForm, Model model) {
        model.addAttribute("projectList", projectService.findAll());
        model.addAttribute("agentList", agentList);
        return "users/createForm";
    }

    @PostMapping
    public String createUser(@Validated UserForm form, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return showCreateForm(form, model);
        }
        userService.createUser(form.getMail(), form.getPassword(), form.getAgent(), form.getCompany(), form.getAuthority());
        return "redirect:/users";
    }
}

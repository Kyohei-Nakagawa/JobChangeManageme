package com.example.jcm.service;

import com.example.jcm.repository.ProjectRepository;
import com.example.jcm.repository.model.ProjectModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<ProjectModel> findAll() {
        return projectRepository.findAll();
    }
}

package com.example.jcm.service;

import com.example.jcm.repository.ProjectRepository;
import com.example.jcm.repository.entity.ProjectEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<ProjectEntity> findAll() {
        return projectRepository.findAll();
    }

    public ProjectEntity findById(long projectId) {
        return projectRepository.findById(projectId);
    }
}

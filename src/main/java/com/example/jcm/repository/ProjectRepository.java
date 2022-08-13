package com.example.jcm.repository;

import com.example.jcm.repository.model.ProjectModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProjectRepository {

    @Select("select * from projects")
    List<ProjectModel> findAll();
}

package com.example.jcm.repository;

import com.example.jcm.repository.entity.ProjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProjectRepository {

    @Select("select * from projects")
    List<ProjectEntity> findAll();

    @Select("select * from projects where id = #{projectId}")
    ProjectEntity findById(long projectId);
}

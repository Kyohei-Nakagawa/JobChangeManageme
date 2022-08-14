package com.example.jcm.repository;

import com.example.jcm.repository.entity.ProjectEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProjectRepository {

    @Select("select * from projects")
    List<ProjectEntity> findAll();

    @Select("select * from projects where id = #{projectId}")
    ProjectEntity findById(int projectId);

    @Insert("insert into projects (status, agent, company, title, programming, detail, uptime, register)\n" +
            "values (#{status}, #{agent}, #{company}, #{title}, #{programming}, #{detail}, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP())")
    public void addProject(String status, String agent, String company, String title, String programming, String detail);

    @Update("update projects set status=#{status}, detail=#{detail} where id = #{projectId}")
    public void editProject(int projectId, String status, String detail);
}

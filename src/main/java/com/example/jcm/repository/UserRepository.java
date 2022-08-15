package com.example.jcm.repository;

import com.example.jcm.repository.entity.ProjectEntity;
import com.example.jcm.repository.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRepository {

    @Select("select * from users")
    List<UserEntity> findAll();
}

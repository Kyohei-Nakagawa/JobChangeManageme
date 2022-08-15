package com.example.jcm.repository;

import com.example.jcm.repository.entity.ProjectEntity;
import com.example.jcm.repository.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRepository {

    @Select("select * from users")
    List<UserEntity> findAll();

    @Insert("insert into users (mail, password, agent, company, authority, register)\n" +
            "values (#{mail}, #{password}, #{agent}, #{company}, #{authority}, CURRENT_TIMESTAMP())")
    void createUser(String mail, String password, String agent, String company, String authority);
}

package com.example.jcm.service;

import com.example.jcm.repository.UserRepository;
import com.example.jcm.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public void createUser(String mail, String password, String agent, String company, String authority) {
        userRepository.createUser(mail, password, agent, company, authority);
    }
}

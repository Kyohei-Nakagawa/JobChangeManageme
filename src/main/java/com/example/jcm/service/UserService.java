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
}

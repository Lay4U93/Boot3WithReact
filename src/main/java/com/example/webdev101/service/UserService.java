package com.example.webdev101.service;

import com.example.webdev101.model.UserEntity;
import com.example.webdev101.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity create(final UserEntity userEntity){
        if (userEntity == null || userEntity.getUsername() == null ){
            throw new RuntimeException("Invalid arguments");
        }
        final String username = userEntity.getUsername();
        if(userRepository.existsByUsername(username)){
            throw new RuntimeException("Username already exists");
        }

        return userRepository.save(userEntity);
    }

    public UserEntity getByCredentials(final String username, final String password){
        return userRepository.findByUsernameAndPassword(username, password);
    }
}

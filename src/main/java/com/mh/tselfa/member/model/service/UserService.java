package com.mh.tselfa.member.model.service;


import java.util.List;
import java.util.Optional;

import com.mh.tselfa.member.model.Entity.UserEntity;
import com.mh.tselfa.member.model.dto.User;
import com.mh.tselfa.member.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll().stream().map(UserEntity::toDTO).toList();
    }

    public List<User> findById(String instCode) {
        return userRepository.findById(instCode).stream().map(UserEntity::toDTO).toList();
    }

    public UserEntity save(User user) {
        return userRepository.save(user.toEntity());
    }

    public void deleteById(String instCode) {
        userRepository.deleteById(instCode);
    }
}
package com.mh.tselfa.member.model.service;


import java.util.List;
import java.util.Optional;

import com.mh.tselfa.member.model.dto.User;
import com.mh.tselfa.member.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(String instCode) {
        return userRepository.findById(instCode);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(String instCode) {
        userRepository.deleteById(instCode);
    }
}
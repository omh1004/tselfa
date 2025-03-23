package com.mh.tselfa.member.controller;


import java.util.List;

import com.mh.tselfa.member.model.dto.User;
import com.mh.tselfa.member.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{instCode}")
    public ResponseEntity<User> getUserById(@PathVariable String instCode) {
        return userService.findById(instCode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{instCode}")
    public ResponseEntity<User> updateUser(@PathVariable String instCode, @RequestBody User user) {
        return userService.findById(instCode)
                .map(existingUser -> {
                    user.setInstCode(instCode);
                    return ResponseEntity.ok(userService.save(user));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{instCode}")
    public ResponseEntity<Void> deleteUser(@PathVariable String instCode) {
        return userService.findById(instCode)
                .map(user -> {
                    userService.deleteById(instCode);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

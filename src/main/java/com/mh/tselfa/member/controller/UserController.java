package com.mh.tselfa.member.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mh.tselfa.member.model.Entity.UserEntity;
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
        List<User> users = userService.findAll();
//        List<User> users = new ArrayList<User>();
//        entities.forEach(e->{
//           users.add(e.toDTO());
//        });
        return users;
//        return userService.findAll();
    }

    @GetMapping("/{instCode}")
    public ResponseEntity<User> getUserById(@PathVariable String instCode) {
        List<User> users = userService.findById(instCode);
        if(users.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(users.get(0));
        }
//        return userService.findById(instCode)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserEntity createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{instCode}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable String instCode, @RequestBody User user) {
        List<User> users = userService.findById(instCode);
        if(users.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else{
            user.setInstCode(instCode);
            return ResponseEntity.ok().body(userService.save(user));
        }
//        return userService.findById(instCode)
//                .map(existingUser -> {
//                    user.setInstCode(instCode);
//                    return ResponseEntity.ok(userService.save(user));
//                })
//                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{instCode}")
    public ResponseEntity<Void> deleteUser(@PathVariable String instCode) {
        List<User> users = userService.findById(instCode);
        if(users.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else{
            userService.deleteById(instCode);
            return ResponseEntity.ok().build();
        }
//        return userService.findById(instCode)
//                .map(user -> {
//                    userService.deleteById(instCode);
//                    return ResponseEntity.ok().<Void>build();
//                })
//                .orElse(ResponseEntity.notFound().build());
    }
}

package com.demo2.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo2.demo2.entity.UserEntity;
import com.demo2.demo2.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired

    private UserService userService;

    @PostMapping
    public UserEntity newUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }

    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get")
    public UserEntity findByUsername(@RequestParam String param) {
        return userService.findByUsername(param);
    }

}

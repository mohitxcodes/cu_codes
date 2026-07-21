package com.demo2.demo2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo2.demo2.entity.UserEntity;
import com.demo2.demo2.respositry.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity createUser(UserEntity user) {
        return userRepo.save(user);
    }

    public UserEntity findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }

}

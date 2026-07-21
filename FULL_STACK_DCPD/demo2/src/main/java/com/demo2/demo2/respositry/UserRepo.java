package com.demo2.demo2.respositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo2.demo2.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String userrname);

    UserEntity findByEmail(String email);

}

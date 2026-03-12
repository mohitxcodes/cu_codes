package com.demo2.demo2.respositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo2.demo2.entity.PostEntity;
import com.demo2.demo2.entity.UserEntity;

public interface PostRepo extends JpaRepository<PostEntity, Long> {

    PostEntity findByTitle(String title);

    List<PostEntity> findByUser(UserEntity user);

}

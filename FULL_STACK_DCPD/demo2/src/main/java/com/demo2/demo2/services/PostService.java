package com.demo2.demo2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo2.demo2.dto.PostDto;
import com.demo2.demo2.entity.PostEntity;
import com.demo2.demo2.entity.UserEntity;
import com.demo2.demo2.respositry.PostRepo;
import com.demo2.demo2.respositry.UserRepo;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    public PostEntity createPost(PostDto postDto) {
        UserEntity user = userRepo.findById(postDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        PostEntity post = new PostEntity();

        post.setTitle(postDto.getTitle());
        post.setSubTitle(postDto.getSubTitle());
        post.setContent(postDto.getContent());
        post.setUser(user);
        return postRepo.save(post);

    }

    public List<PostEntity> getPostsByUser(Long userId) {
        return postRepo.findByUser(userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found")));
    }

    public List<PostEntity> getAllPosts() {
        return postRepo.findAll();
    }

    public PostEntity getPostByTitle(String title) {
        return postRepo.findByTitle(title);
    }

}

package com.demo2.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo2.demo2.dto.PostDto;
import com.demo2.demo2.entity.PostEntity;
import com.demo2.demo2.services.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public PostEntity createPost(@RequestBody PostDto postDto) {
        return postService.createPost(postDto);
    }

    @GetMapping("/all")
    public List<PostEntity> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{userId}")
    public List<PostEntity> getPostsByUser(@PathVariable Long userId) {
        return postService.getPostsByUser(userId);
    }

    @GetMapping
    public PostEntity getPostByTitle(@RequestParam String title) {
        return postService.getPostByTitle(title);
    }

}

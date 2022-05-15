package com.blogapp.controller;

import com.blogapp.dto.PostDto;
import com.blogapp.dto.request.CreatePostRequest;
import com.blogapp.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/get")
    public ResponseEntity<List<PostDto>> getAllPosts() {
        return ResponseEntity.ok(postService.fetchAllPosts());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable String id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody CreatePostRequest request) {
        return ResponseEntity.ok(postService.createPost(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable String id) {
        return ResponseEntity.ok(postService.updatePost(id, postDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable String id) {
        return ResponseEntity.ok(postService.deletePost(id));
    }

}

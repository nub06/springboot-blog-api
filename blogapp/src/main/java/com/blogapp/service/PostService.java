package com.blogapp.service;

import com.blogapp.entity.Post;
import com.blogapp.entity.User;
import com.blogapp.exception.PostNotFoundException;
import com.blogapp.dto.PostDto;
import com.blogapp.mapper.PostMapper;
import com.blogapp.dto.request.CreatePostRequest;
import com.blogapp.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final UserService userService;

    public PostService(PostRepository postRepository, PostMapper postMapper, UserService userService) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
        this.userService = userService;
    }

    public List<PostDto> fetchAllPosts() {

        return postRepository.findAll()
                .stream()
                .map(postMapper::toDto)
                .collect(Collectors.toList());

    }

    public PostDto getPostById(String id) {
        return postMapper.toDto(findPostById(id));
    }


    public PostDto createPost(CreatePostRequest request) {

        User user = userService.findUserById(request.getUserId());
        Post post = new Post();

        post.setUser(user);
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());

        return postMapper.toDto(postRepository.save(post));

    }


    public PostDto updatePost(String id, PostDto postDto) {

        return postRepository.findById(id)
                .map(entry -> update(entry, postDto))
                .map(postMapper::toDto)
                .orElseThrow(() -> new PostNotFoundException("No post found for " + id));

    }


    public String deletePost(String id) {

        Post existingPost = findPostById(id);
        postRepository.delete(existingPost);
        return "Post " + existingPost.getContent() + " with this " + id + " is deleted!";
    }


    private Post update(Post post, PostDto postDto) {

        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());

        return post;
    }


    public Post findPostById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Post with this " + id + " not found!"));
    }


}

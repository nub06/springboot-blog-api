package com.blogapp.service;

import com.blogapp.entity.Comment;
import com.blogapp.entity.Post;
import com.blogapp.entity.User;
import com.blogapp.exception.CommentNotFoundException;
import com.blogapp.dto.CommentDto;
import com.blogapp.mapper.CommentMapper;
import com.blogapp.dto.request.CreateCommentRequest;
import com.blogapp.repository.CommentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    private final UserService userService;
    private final PostService postService;


    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper,
                          UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
        this.userService = userService;
        this.postService = postService;
    }

    public List<CommentDto> fetchAllComments() {

        return commentRepository.findAll()
                .stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());

    }

    public CommentDto getCommentById(String id) {
        return commentMapper.toDto(findCommentById(id));
    }


    public CommentDto createComment(CreateCommentRequest request) {

        User user = userService.findUserById(request.getUserId());
        Post post = postService.findPostById(request.getPostId());

        Comment comment = new Comment();

        comment.setText(request.getText());
        comment.setUser(user);
        comment.setPost(post);

        return commentMapper.toDto(commentRepository.save(comment));


    }

    public CommentDto updateComment(String id, CommentDto commentDto) {

        return commentRepository.findById(id)
                .map(entry -> update(entry, commentDto))
                .map(commentMapper::toDto)
                .orElseThrow(() -> new CommentNotFoundException("No comment found for " + id));

    }


    public String deleteComment(String id) {

        Comment existingComment = findCommentById(id);
        commentRepository.delete(existingComment);
        return "This Comment: " + existingComment.getText() + " with this " + "" + id + "" + " is deleted";
    }


    private Comment update(Comment comment, CommentDto commentDto) {

        comment.setText(commentDto.getText());
        comment.setId(commentDto.getId());
        return comment;
    }

    public Comment findCommentById(String id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException("Comment with this " + id + " not found!"));
    }


}

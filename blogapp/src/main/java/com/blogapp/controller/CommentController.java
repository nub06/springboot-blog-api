package com.blogapp.controller;

import com.blogapp.dto.CommentDto;
import com.blogapp.dto.request.CreateCommentRequest;
import com.blogapp.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/api/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<CommentDto>> getAllComments() {
        return ResponseEntity.ok(commentService.fetchAllComments());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable String id) {
        return ResponseEntity.ok(commentService.getCommentById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<CommentDto> createComment(@Valid @RequestBody CreateCommentRequest request) {
        return ResponseEntity.ok(commentService.createComment(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CommentDto> updateComment(@Valid @RequestBody CommentDto commentDto, @PathVariable String id) {
        return ResponseEntity.ok(commentService.updateComment(id, commentDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable String id) {
        return ResponseEntity.ok(commentService.deleteComment(id));
    }


}

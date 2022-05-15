package com.blogapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String id;
    private String userName;
    private String firstName;
    private String lastName;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)

    private List<PostDto> post = new ArrayList<>();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)

    private List<CommentDto> commentDto = new ArrayList<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<PostDto> getPost() {
        return post;
    }

    public void setPost(List<PostDto> post) {
        this.post = post;
    }

    public List<CommentDto> getCommentDto() {
        return commentDto;
    }

    public void setCommentDto(List<CommentDto> commentDto) {
        this.commentDto = commentDto;
    }
}

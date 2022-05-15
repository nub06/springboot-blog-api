package com.blogapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

public class PostDto {

    private String id;
    private String title;
    private String content;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserDto userDto;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CommentDto> commentDto = new ArrayList<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public List<CommentDto> getCommentDto() {
        return commentDto;
    }

    public void setCommentDto(List<CommentDto> commentDto) {
        this.commentDto = commentDto;
    }
}

package com.blogapp.dto.request;


import javax.validation.constraints.NotBlank;

public class CreatePostRequest {

    @NotBlank(message = "The title of the post must not be blank")
    private String title;
    @NotBlank(message = "The user_id of the post must not be blank")
    private String userId;
    @NotBlank(message = "The content of the post must not be blank")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

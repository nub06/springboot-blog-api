package com.blogapp.dto.request;

import javax.validation.constraints.NotBlank;


public class CreateCommentRequest {

    @NotBlank(message = "The text of comment must not be blank")
    private String text;
    @NotBlank(message = "The user_id of comment must not be blank")
    private String userId;
    @NotBlank(message = "The post_id of comment must not be blank")
    private String postId;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}

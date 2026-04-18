package com.example.blogapp_1.dto;

import java.time.LocalDateTime;

public class PostDTO {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private int commentCount;

    public PostDTO(Long id, String title, String content,
                   LocalDateTime createdAt, int commentCount) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.commentCount = commentCount;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public int getCommentCount() { return commentCount; }
}
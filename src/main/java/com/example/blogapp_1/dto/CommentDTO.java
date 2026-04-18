package com.example.blogapp_1.dto;

public class CommentDTO {

    private Long id;
    private String author;
    private String text;
    private Long postId;

    public CommentDTO(Long id, String author, String text, Long postId) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.postId = postId;
    }

    public Long getId() { return id; }
    public String getAuthor() {
        return author;
    }
    public String getText() {
        return text;
    }
    public Long getPostId() {
        return postId;
    }
}
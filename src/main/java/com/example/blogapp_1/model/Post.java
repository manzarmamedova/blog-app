package com.example.blogapp_1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TR: Başlık boş olamaz ve uzunluk kontrolü
    // KA: სათაური ცარიელი არ უნდა იყოს და უნდა ჰქონდეს სიგრძის შეზღუდვა
    @NotBlank(message = "Title cannot be empty")
    @Size(min = 3, max = 100, message = "Title must be between 3-100 characters")
    private String title;

    // TR: İçerik boş olamaz ve uzunluk kontrolü
    // KA: კონტენტი ცარიელი არ უნდა იყოს და უნდა ჰქონდეს სიგრძის შეზღუდვა
    @NotBlank(message = "Content cannot be empty")
    @Size(min = 10, max = 5000, message = "Content must be between 10-5000 characters")
    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();

    // TR: Bir post'un birden fazla yorumu olabilir
    // KA: ერთ პოსტს შეიძლება ჰქონდეს რამდენიმე კომენტარი
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    // TR: Dosya yolu (file upload için gerekli)
    // KA: ფაილის მისამართი (ფაილის ატვირთვისთვის საჭიროა)
    private String imagePath;

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    // TR: FreeMarker için tarih formatlama
    // KA: თარიღის ფორმატირება FreeMarker-ისთვის
    public String getFormattedDate() {
        if (createdAt == null) return "";
        return createdAt.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }

    public String getShortDate() {
        if (createdAt == null) return "";
        return createdAt.format(DateTimeFormatter.ofPattern("MMM dd"));
    }
}

package com.example.blogapp_1;

import com.example.blogapp_1.model.Post;
import com.example.blogapp_1.repository.PostRepository;
import com.example.blogapp_1.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PostServiceIntegrationTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    void setUp() {
        postRepository.deleteAll();
    }

    @Test
    @DisplayName("Integration: Should save and retrieve post successfully")
    void shouldSaveAndRetrievePost() {
        Post post = new Post();
        post.setTitle("Integration Test Post");
        post.setContent("This is an integration test content long enough.");

        Post saved = postService.save(post);
        Post found = postService.getById(saved.getId());

        assertAll(
                () -> assertNotNull(saved.getId()),
                () -> assertEquals("Integration Test Post", found.getTitle()),
                () -> assertEquals("This is an integration test content long enough.", found.getContent())
        );
    }
}
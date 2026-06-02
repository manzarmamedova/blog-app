package com.example.blogapp_1.repository;

import com.example.blogapp_1.model.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @DisplayName("Should persist and retrieve post by ID")
    void shouldPersistAndRetrievePost() {
        Post post = new Post();
        post.setTitle("Persistent Post");
        post.setContent("This post should be saved to the database");
        entityManager.persist(post);
        entityManager.flush();

        Optional<Post> found = postRepository.findById(post.getId());

        assertTrue(found.isPresent());
        assertEquals("Persistent Post", found.get().getTitle());
    }

    @Test
    @DisplayName("Should find posts by title containing keyword (ignore case)")
    void shouldFindByTitleContainingIgnoreCase() {
        Post post1 = new Post();
        post1.setTitle("Spring Boot Guide");
        post1.setContent("Detailed content about Spring Boot");
        entityManager.persist(post1);

        Post post2 = new Post();
        post2.setTitle("Java Fundamentals");
        post2.setContent("Detailed content about Java");
        entityManager.persist(post2);

        entityManager.flush();

        List<Post> results = postRepository.findByTitleContainingIgnoreCase("spring");

        assertEquals(1, results.size());
        assertEquals("Spring Boot Guide", results.get(0).getTitle());
    }

    @Test
    @DisplayName("Should find posts regardless of keyword case")
    void shouldFindByTitleCaseInsensitive() {
        Post post = new Post();
        post.setTitle("Spring Boot Guide");
        post.setContent("Detailed content about Spring Boot");
        entityManager.persist(post);
        entityManager.flush();

        List<Post> upperCase = postRepository.findByTitleContainingIgnoreCase("SPRING");
        List<Post> lowerCase = postRepository.findByTitleContainingIgnoreCase("spring");

        assertAll(
                () -> assertEquals(1, upperCase.size()),
                () -> assertEquals(1, lowerCase.size())
        );
    }
}
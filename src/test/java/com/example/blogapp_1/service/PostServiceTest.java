package com.example.blogapp_1.service;

import com.example.blogapp_1.model.Post;
import com.example.blogapp_1.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @Test
    @DisplayName("Should return correct post when found by ID")
    void shouldReturnPostWhenFound() {
        Post mockPost = new Post();
        mockPost.setId(1L);
        mockPost.setTitle("Test Title");
        mockPost.setContent("Test content long enough");

        when(postRepository.findById(1L)).thenReturn(Optional.of(mockPost));

        Post result = postService.getById(1L);

        assertNotNull(result);
        assertEquals("Test Title", result.getTitle());
        verify(postRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Should throw exception when post not found")
    void shouldThrowExceptionWhenPostNotFound() {
        when(postRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> postService.getById(99L));

        verify(postRepository, times(1)).findById(99L);
    }

    @Test
    @DisplayName("Should call repository save when saving a post")
    void shouldSavePost() {
        Post newPost = new Post();
        newPost.setTitle("New Post");
        newPost.setContent("New content long enough");

        Post savedPost = new Post();
        savedPost.setId(1L);
        savedPost.setTitle("New Post");

        when(postRepository.save(any(Post.class))).thenReturn(savedPost);

        Post result = postService.save(newPost);

        assertNotNull(result.getId());
        assertEquals("New Post", result.getTitle());
        verify(postRepository, times(1)).save(any(Post.class));
    }

    @Test
    @DisplayName("Should return all posts with correct count")
    void shouldReturnAllPosts() {
        Post p1 = new Post(); p1.setId(1L); p1.setTitle("Post 1");
        Post p2 = new Post(); p2.setId(2L); p2.setTitle("Post 2");

        when(postRepository.findAll()).thenReturn(List.of(p1, p2));

        List<Post> result = postService.getAll();

        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(2, result.size()),
                () -> assertEquals("Post 1", result.get(0).getTitle())
        );
        verify(postRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should call deleteById when post exists")
    void shouldDeletePostWhenExists() {
        when(postRepository.existsById(1L)).thenReturn(true);
        doNothing().when(postRepository).deleteById(1L);

        postService.delete(1L);

        verify(postRepository, times(1)).existsById(1L);
        verify(postRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("Should throw exception when deleting non-existent post")
    void shouldThrowExceptionWhenDeletingNonExistentPost() {
        when(postRepository.existsById(99L)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> postService.delete(99L));

        verify(postRepository, times(1)).existsById(99L);
        verify(postRepository, never()).deleteById(99L);
    }
}
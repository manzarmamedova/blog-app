package com.example.blogapp_1.controller;

import com.example.blogapp_1.model.Post;
import com.example.blogapp_1.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PostController.class)
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Test
    @DisplayName("GET / — home page should return with post list")
    void shouldReturnHomePage() throws Exception {
        Post p1 = new Post(); p1.setId(1L); p1.setTitle("Post 1");
        Post p2 = new Post(); p2.setId(2L); p2.setTitle("Post 2");

        when(postService.getAll()).thenReturn(List.of(p1, p2));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("posts"))
                .andExpect(model().attribute("posts", hasSize(2)));

        verify(postService, times(1)).getAll();
    }

    @Test
    @DisplayName("GET /post/{id} — post detail page should be returned")
    void shouldReturnPostDetailPage() throws Exception {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("Detail Post");
        post.setContent("Detail content long enough");

        when(postService.getById(1L)).thenReturn(post);

        mockMvc.perform(get("/post/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("post"))
                .andExpect(model().attribute("post", post));

        verify(postService, times(1)).getById(1L);
    }

    @Test
    @DisplayName("GET /about — about page should be returned")
    void shouldReturnAboutPage() throws Exception {
        mockMvc.perform(get("/about"))
                .andExpect(status().isOk())
                .andExpect(view().name("about"));
    }
}
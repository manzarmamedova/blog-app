package com.example.blogapp_1.controller;

import com.example.blogapp_1.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Home page
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", postService.getAll());
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    // Post detail
    @GetMapping("/post/{id}")
    public String postDetail(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.getById(id));
        return "post";
    }
}

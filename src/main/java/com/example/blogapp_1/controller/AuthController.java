package com.example.blogapp_1.controller;

import com.example.blogapp_1.dto.RegisterDTO;
import com.example.blogapp_1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(RegisterDTO dto) {
        userService.register(dto);
        return "redirect:/login";
    }
}
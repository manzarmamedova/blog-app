package com.example.blogapp_1.controller;

import com.example.blogapp_1.dto.RegisterDTO;
import com.example.blogapp_1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // LOGIN PAGE
    @GetMapping("/login")
    public String loginPage(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "registered", required = false) String registered,
            @RequestParam(value = "logout", required = false) String logout,
            Model model
    ) {

        if (error != null) {
            model.addAttribute("error", "Invalid username or password");
        }

        if (registered != null) {
            model.addAttribute("success", "Registration successful. Please login.");
        }

        if (logout != null) {
            model.addAttribute("success", "Logged out successfully.");
        }

        return "login";
    }

    // REGISTER PAGE
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new RegisterDTO());
        return "register";
    }

    // REGISTER SUBMIT
    @PostMapping("/register")
    public String register(@ModelAttribute RegisterDTO dto, Model model) {

        try {
            userService.register(dto);
            return "redirect:/login?registered";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
    @GetMapping("/access-denied")
    public String accessDenied(Model model) {
        model.addAttribute("errorMessage", "Bu sayfaya erişim yetkiniz yok.");
        return "error";
    }
}
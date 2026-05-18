package com.example.blogapp_1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterDTO {

    @NotBlank(message = "Username boş olamaz")
    @Size(min = 3, max = 20, message = "Username 3-20 karakter olmalı")
    private String username;

    @NotBlank(message = "Password boş olamaz")
    @Size(min = 6, max = 100, message = "Password en az 6 karakter olmalı")
    private String password;

    public RegisterDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
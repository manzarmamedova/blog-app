package com.example.blogapp_1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BlogController {

    @GetMapping("/")
    public String displayBlog(Model model) {


        List<String> posts = List.of(
                "Hello World!",
                " I hope I understood the assignment correctly"
        );

        model.addAttribute("posts", posts);
        model.addAttribute("title", "My Blog");

        return "index";
    }
}

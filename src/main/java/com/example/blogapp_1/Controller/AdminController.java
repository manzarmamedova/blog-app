package com.example.blogapp_1.Controller;

import com.example.blogapp_1.Service.PostService;
import com.example.blogapp_1.model.Post;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private final PostService postService;

    // TR: upload klasörü config'ten alınıyor
    // KA: ატვირთვის ფოლდერი კონფიგურაციიდან მოდის
    @Value("${app.upload-dir}")
    private String uploadDir;

    public AdminController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        logger.debug("Opening create post form");
        model.addAttribute("post", new Post());
        return "create-post";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute Post post,
                         BindingResult result,
                         @RequestParam("file") MultipartFile file,
                         Model model,
                         RedirectAttributes redirectAttributes) {

        // TR: validation hataları UI'ya gönderiliyor
        // KA: ვალიდაციის შეცდომები იგზავნება UI-ზე
        if (result.hasErrors()) {
            logger.warn("Validation failed on create: {}", result.getAllErrors());
            model.addAttribute("errors", result.getAllErrors());
            return "create-post";
        }

        // TR: dosya yükleme işlemi
        // KA: ფაილის ატვირთვის პროცესი
        if (!file.isEmpty()) {
            try {
                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                File uploadPath = new File(uploadDir);

                if (!uploadPath.exists()) {
                    uploadPath.mkdirs();
                }

                File dest = new File(uploadDir + File.separator + fileName);
                file.transferTo(dest);

                post.setImagePath("/" + uploadDir + "/" + fileName);

                logger.info("File uploaded: {}", fileName);

            } catch (IOException e) {
                logger.error("File upload failed", e);
                model.addAttribute("errorMessage", "File upload failed");
                return "create-post";
            }
        }

        postService.save(post);

        logger.info("New post created: '{}'", post.getTitle());
        redirectAttributes.addFlashAttribute("successMessage", "Post created successfully!");

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        logger.debug("Opening edit form for post id: {}", id);
        model.addAttribute("post", postService.getById(id));
        return "create-post";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id,
                         @Valid @ModelAttribute Post post,
                         BindingResult result,
                         @RequestParam("file") MultipartFile file,
                         Model model,
                         RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            logger.warn("Validation failed on update for post id: {}", id);
            model.addAttribute("errors", result.getAllErrors());
            return "create-post";
        }

        // TR: update sırasında da file upload destekleniyor
        // KA: განახლებისასაც მუშაობს ფაილის ატვირთვა
        if (!file.isEmpty()) {
            try {
                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                File dest = new File(uploadDir + File.separator + fileName);
                file.transferTo(dest);

                post.setImagePath("/" + uploadDir + "/" + fileName);

            } catch (IOException e) {
                logger.error("File upload failed", e);
            }
        }

        postService.update(id, post);

        logger.info("Post updated, id: {}", id);
        redirectAttributes.addFlashAttribute("successMessage", "Post updated successfully!");

        return "redirect:/post/" + id;
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id,
                         RedirectAttributes redirectAttributes) {
        logger.warn("Delete requested for post id: {}", id);
        postService.delete(id);
        redirectAttributes.addFlashAttribute("successMessage", "Post deleted.");
        return "redirect:/";
    }
}

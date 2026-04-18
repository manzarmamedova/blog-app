package com.example.blogapp_1.Controller;

import com.example.blogapp_1.Service.PostService;
import com.example.blogapp_1.dto.PostDTO;
import com.example.blogapp_1.model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class RestPostController {

    private static final Logger logger = LoggerFactory.getLogger(RestPostController.class);

    private final PostService postService;

    public RestPostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAll() {
        logger.info("REST GET /api/posts");
        List<PostDTO> posts = postService.getAll()
                .stream()
                .map(p -> new PostDTO(
                        p.getId(),
                        p.getTitle(),
                        p.getContent(),
                        p.getCreatedAt(),
                        p.getComments().size()
                ))
                .toList();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getOne(@PathVariable Long id) {
        logger.info("REST GET /api/posts/{}", id);
        Post post = postService.getById(id);
        PostDTO dto = new PostDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                post.getComments().size()
        );
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PostDTO> create(@RequestBody Post post) {
        logger.info("REST POST /api/posts - title: {}", post.getTitle());
        Post saved = postService.save(post);
        PostDTO dto = new PostDTO(
                saved.getId(),
                saved.getTitle(),
                saved.getContent(),
                saved.getCreatedAt(),
                0
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> update(@PathVariable Long id,
                                          @RequestBody Post post) {
        logger.info("REST PUT /api/posts/{}", id);
        Post updated = postService.update(id, post);
        PostDTO dto = new PostDTO(
                updated.getId(),
                updated.getTitle(),
                updated.getContent(),
                updated.getCreatedAt(),
                updated.getComments().size()
        );
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.warn("REST DELETE /api/posts/{}", id);
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
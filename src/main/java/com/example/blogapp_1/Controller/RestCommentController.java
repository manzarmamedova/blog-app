package com.example.blogapp_1.Controller;

import com.example.blogapp_1.Service.CommentService;
import com.example.blogapp_1.dto.CommentDTO;
import com.example.blogapp_1.model.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class RestCommentController {

    private static final Logger logger = LoggerFactory.getLogger(RestCommentController.class);

    private final CommentService commentService;

    public RestCommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDTO> create(@RequestBody Comment comment) {
        logger.info("REST POST /api/comments - author: {}", comment.getAuthor());
        Comment saved = commentService.save(comment);
        CommentDTO dto = new CommentDTO(
                saved.getId(),
                saved.getAuthor(),
                saved.getText(),
                saved.getPost() != null ? saved.getPost().getId() : null
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.warn("REST DELETE /api/comments/{}", id);
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
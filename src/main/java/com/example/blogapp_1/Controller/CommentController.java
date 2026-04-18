package com.example.blogapp_1.Controller;

import com.example.blogapp_1.Service.CommentService;
import com.example.blogapp_1.Service.PostService;
import com.example.blogapp_1.model.Comment;
import com.example.blogapp_1.model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    private final CommentService commentService;
    private final PostService postService;

    public CommentController(CommentService commentService,
                             PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    @PostMapping("/post/{id}/comment")
    public String addComment(@PathVariable Long id,
                             @RequestParam String author,
                             @RequestParam String text) {

        logger.info("New comment on post id: {} by '{}'", id, author);

        Post post = postService.getById(id);

        Comment comment = new Comment();
        comment.setAuthor(author);
        comment.setText(text);
        comment.setPost(post);

        commentService.save(comment);

        logger.debug("Comment saved, redirecting to post: {}", id);

        return "redirect:/post/" + id;
    }
}
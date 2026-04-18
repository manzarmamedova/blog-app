package com.example.blogapp_1.Service;

import com.example.blogapp_1.model.Comment;
import com.example.blogapp_1.model.Post;
import com.example.blogapp_1.repository.CommentRepository;
import com.example.blogapp_1.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository,
                          PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public List<Comment> getAll() {
        logger.info("Fetching all comments");
        return commentRepository.findAll();
    }

    public Comment getById(Long id) {
        logger.info("Fetching comment with id: {}", id);
        return commentRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Comment not found with id: {}", id);
                    return new RuntimeException("Comment not found : " + id);
                });
    }

    @Transactional
    public Comment save(Comment comment) {
        logger.info("Saving comment by '{}'", comment.getAuthor());
        Comment saved = commentRepository.save(comment);
        logger.debug("Comment saved with id: {}", saved.getId());
        return saved;
    }

    @Transactional
    public Comment addToPost(Long postId, Comment comment) {
        logger.info("Adding comment to post id: {}", postId);
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> {
                    logger.error("Post not found with id: {}", postId);
                    return new RuntimeException("Post not found: " + postId);
                });
        comment.setPost(post);
        Comment saved = commentRepository.save(comment);
        logger.debug("Comment saved with id: {}", saved.getId());
        return saved;
    }

    @Transactional
    public void delete(Long id) {
        logger.warn("Deleting comment with id: {}", id);
        if (!commentRepository.existsById(id)) {
            logger.error("Cannot delete - comment not found with id: {}", id);
            throw new RuntimeException("Comment not found: " + id);
        }
        commentRepository.deleteById(id);
        logger.info("Comment deleted successfully, id: {}", id);
    }
}
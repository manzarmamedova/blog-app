package com.example.blogapp_1.Service;

import com.example.blogapp_1.model.Post;
import com.example.blogapp_1.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    private static final Logger logger = LoggerFactory.getLogger(PostService.class);

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAll() {
        logger.info("Fetching all posts");
        return postRepository.findAll();
    }

    public Post getById(Long id) {
        logger.info("Fetching post with id: {}", id);
        return postRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Post not found with id: {}", id);
                    return new RuntimeException("Post not found: " + id);
                });
    }

    @Transactional
    public Post save(Post post) {
        logger.info("Saving post: '{}'", post.getTitle());
        Post saved = postRepository.save(post);
        logger.debug("Post saved with id: {}", saved.getId());
        return saved;
    }

    @Transactional
    public Post update(Long id, Post updatedPost) {
        logger.info("Updating post with id: {}", id);
        Post post = getById(id);
        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        logger.debug("Post updated: '{}'", post.getTitle());
        return postRepository.save(post);
    }

    @Transactional
    public void delete(Long id) {
        logger.warn("Deleting post with id: {}", id);
        if (!postRepository.existsById(id)) {
            logger.error("Cannot delete - post not found with id: {}", id);
            throw new RuntimeException("Post not found: " + id);
        }
        postRepository.deleteById(id);
        logger.info("Post deleted successfully, id: {}", id);
    }

    public List<Post> search(String keyword) {
        logger.info("Searching posts with keyword: '{}'", keyword);
        return postRepository.findByTitleContainingIgnoreCase(keyword);
    }
}
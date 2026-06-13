package com.example.blogapp_1.service;

import com.example.blogapp_1.model.Post;
import com.example.blogapp_1.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;

import java.util.List;

@Service
public class PostService {

    private static final Logger logger = LoggerFactory.getLogger(PostService.class);

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Cacheable(value = "posts")
    public List<Post> getAll() {
        logger.info("Fetching all posts");
        return postRepository.findAll();
    }
    @Cacheable(value = "post", key = "#id")
    public Post getById(Long id) {
        logger.info("Fetching post with id: {}", id);
        return postRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Post not found with id: {}", id);
                    return new RuntimeException("Post not found: " + id);
                });
    }
    @Caching(evict = {
            @CacheEvict(value = "posts", allEntries = true),
            @CacheEvict(value = "post", key = "#result.id")
    })

    @Transactional
    public Post save(Post post) {
        logger.info("Saving post: '{}'", post.getTitle());
        Post saved = postRepository.save(post);
        logger.debug("Post saved with id: {}", saved.getId());
        return saved;
    }

    @Caching(evict = {
            @CacheEvict(value = "posts", allEntries = true),
            @CacheEvict(value = "post", key = "#id")
    })

    @Transactional
    public Post update(Long id, Post updatedPost) {
        logger.info("Updating post with id: {}", id);
        Post post = getById(id);
        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        logger.debug("Post updated: '{}'", post.getTitle());
        return postRepository.save(post);
    }

    @Caching(evict = {
            @CacheEvict(value = "posts", allEntries = true),
            @CacheEvict(value = "post", key = "#id")
    })

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
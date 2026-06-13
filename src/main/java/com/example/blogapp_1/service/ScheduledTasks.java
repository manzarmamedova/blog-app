package com.example.blogapp_1.service;

import com.example.blogapp_1.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private final PostRepository postRepository;

    public ScheduledTasks(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Runs every 60 seconds (60000 ms) and logs the total number of posts
    @Scheduled(fixedRate = 60000)
    public void logPostStatistics() {
        long count = postRepository.count();
        logger.info("[Scheduled Task] Total posts in database: {}", count);
    }
}
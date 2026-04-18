<#include "layout.ftlh">

<@layout title="About">

    <div class="about-page">
        <div class="about-hero">
            <div class="about-avatar-large">A</div>
            <h1>About DevBlog</h1>
            <p>A blog dedicated to software development, Java, and Spring Boot.</p>
        </div>

        <div class="about-grid">
            <div class="about-section-card">
                <h2>What is DevBlog?</h2>
                <p>DevBlog is a personal blog built with Spring Boot and FreeMarker. It covers topics ranging from core Java concepts to advanced Spring Boot features, database management, and RESTful API design.</p>
                <p>Every article is written with the goal of making complex topics simple and accessible for developers at all levels.</p>
            </div>

            <div class="about-section-card">
                <h2>Tech Stack</h2>
                <div class="tech-list">
                    <div class="tech-item">
                        <div class="tech-icon java">J</div>
                        <div>
                            <div class="tech-name">Java 21</div>
                            <div class="tech-desc">Primary language</div>
                        </div>
                    </div>
                    <div class="tech-item">
                        <div class="tech-icon spring">S</div>
                        <div>
                            <div class="tech-name">Spring Boot</div>
                            <div class="tech-desc">Web framework</div>
                        </div>
                    </div>
                    <div class="tech-item">
                        <div class="tech-icon db">P</div>
                        <div>
                            <div class="tech-name">PostgreSQL</div>
                            <div class="tech-desc">Database</div>
                        </div>
                    </div>
                    <div class="tech-item">
                        <div class="tech-icon fm">F</div>
                        <div>
                            <div class="tech-name">FreeMarker</div>
                            <div class="tech-desc">Template engine</div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="about-section-card">
                <h2>Topics Covered</h2>
                <div class="topics-grid">
                    <span class="topic-tag">Spring Boot</span>
                    <span class="topic-tag">Java</span>
                    <span class="topic-tag">JPA & Hibernate</span>
                    <span class="topic-tag">REST APIs</span>
                    <span class="topic-tag">FreeMarker</span>
                    <span class="topic-tag">PostgreSQL</span>
                    <span class="topic-tag">Dependency Injection</span>
                    <span class="topic-tag">Web Development</span>
                </div>
            </div>

            <div class="about-section-card">
                <h2>REST API</h2>
                <p>This blog also exposes a REST API for programmatic access to posts and comments.</p>
                <div class="api-list">
                    <div class="api-item"><span class="method get">GET</span> /api/posts</div>
                    <div class="api-item"><span class="method get">GET</span> /api/posts/{id}</div>
                    <div class="api-item"><span class="method post">POST</span> /api/posts</div>
                    <div class="api-item"><span class="method put">PUT</span> /api/posts/{id}</div>
                    <div class="api-item"><span class="method del">DELETE</span> /api/posts/{id}</div>
                </div>
            </div>
        </div>
    </div>

</@layout>
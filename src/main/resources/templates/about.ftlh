<#include "layout.ftlh">

<@layout title="About">

    <div class="about-page">
        <div class="about-hero">
            <div class="about-avatar-large">A</div>
            <h1>${springMacroRequestContext.getMessage("about.title")}</h1>
            <p>${springMacroRequestContext.getMessage("about.sub")}</p>
        </div>

        <div class="about-grid">
            <div class="about-section-card">
                <h2>${springMacroRequestContext.getMessage("about.what.title")}</h2>
                <p>${springMacroRequestContext.getMessage("about.what.text1")}</p>
                <p>${springMacroRequestContext.getMessage("about.what.text2")}</p>
            </div>

            <div class="about-section-card">
                <h2>${springMacroRequestContext.getMessage("about.tech.title")}</h2>
                <div class="tech-list">
                    <div class="tech-item">
                        <div class="tech-icon java">J</div>
                        <div>
                            <div class="tech-name">Java 21</div>
                            <div class="tech-desc">${springMacroRequestContext.getMessage("about.tech.java.desc")}</div>
                        </div>
                    </div>
                    <div class="tech-item">
                        <div class="tech-icon spring">S</div>
                        <div>
                            <div class="tech-name">Spring Boot</div>
                            <div class="tech-desc">${springMacroRequestContext.getMessage("about.tech.spring.desc")}</div>
                        </div>
                    </div>
                    <div class="tech-item">
                        <div class="tech-icon db">P</div>
                        <div>
                            <div class="tech-name">PostgreSQL</div>
                            <div class="tech-desc">${springMacroRequestContext.getMessage("about.tech.db.desc")}</div>
                        </div>
                    </div>
                    <div class="tech-item">
                        <div class="tech-icon fm">F</div>
                        <div>
                            <div class="tech-name">FreeMarker</div>
                            <div class="tech-desc">${springMacroRequestContext.getMessage("about.tech.fm.desc")}</div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="about-section-card">
                <h2>${springMacroRequestContext.getMessage("about.topics.title")}</h2>
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
                <h2>${springMacroRequestContext.getMessage("about.api.title")}</h2>
                <p>${springMacroRequestContext.getMessage("about.api.sub")}</p>
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

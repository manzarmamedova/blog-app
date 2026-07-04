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
                <h2>${springMacroRequestContext.getMessage("about.topics.title")}</h2>
                <div class="topics-grid">
                    <span class="topic-tag">Spring Boot</span>
                    <span class="topic-tag">Java</span>
                    <span class="topic-tag">Databases</span>
                    <span class="topic-tag">REST APIs</span>
                    <span class="topic-tag">Web Development</span>
                    <span class="topic-tag">Software Architecture</span>
                    <span class="topic-tag">Best Practices</span>
                    <span class="topic-tag">Tutorials</span>
                </div>
            </div>

            <div class="about-section-card" style="grid-column: 1 / -1;">
                <h2>${springMacroRequestContext.getMessage("about.author.title")}</h2>
                <p>${springMacroRequestContext.getMessage("about.author.text")}</p>
            </div>
        </div>
    </div>

</@layout>

<#include "layout.ftlh">

<@layout title="${post.title}">

    <div class="post-hero">
        <div class="post-hero-inner">
            <div class="breadcrumb">
                <a href="/">Home</a>
                <span>/</span>
                <span>${post.title}</span>
            </div>
            <div class="post-hero-meta">
                <span class="post-category">Article</span>
                <span class="dot">·</span>
                <span>${post.formattedDate}</span>
                <span class="dot">·</span>
                <span>${post.comments?size} comments</span>
            </div>
            <h1 class="post-hero-title">${post.title}</h1>
            <div class="post-hero-author">
                <div class="author-avatar large">A</div>
                <div>
                    <div class="author-name">Admin</div>
                    <div class="author-meta">Developer & Writer</div>
                </div>
                <div class="post-hero-actions">
                    <a href="/admin/edit/${post.id}" class="btn-outline">✏ Edit</a>
                    <form action="/admin/delete/${post.id}" method="post" style="display:inline">
                        <button type="submit"
                                class="btn-outline danger"
                                onclick="return confirm('Delete this post?')">✕ Delete</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="post-layout">
        <article class="post-article">
            <div class="post-body">
                ${post.content}
            </div>

            <div class="post-tags">
                <span class="tag">Java</span>
                <span class="tag">Spring Boot</span>
                <span class="tag">Tutorial</span>
            </div>

            <div class="post-nav">
                <a href="/" class="btn-outline">← Back to Posts</a>
            </div>
        </article>

        <aside class="post-sidebar">
            <div class="sidebar-card">
                <h4 class="sidebar-title">About Author</h4>
                <div class="author-card">
                    <div class="author-avatar large">A</div>
                    <div class="author-name">Admin</div>
                    <div class="author-meta">Developer & Writer</div>
                </div>
            </div>

            <div class="sidebar-card">
                <h4 class="sidebar-title">Comments</h4>
                <div class="comment-stat">${post.comments?size}</div>
                <p class="sidebar-empty">responses to this post</p>
            </div>
        </aside>
    </div>

    <section class="comments-section">
        <div class="comments-inner">
            <h3 class="comments-title">
                Comments
                <span class="count-badge">${post.comments?size}</span>
            </h3>

            <#if post.comments?has_content>
                <div class="comment-list">
                    <#list post.comments as comment>
                        <div class="comment-card">
                            <div class="comment-avatar">
                                ${comment.author?substring(0,1)?upper_case}
                            </div>
                            <div class="comment-content">
                                <div class="comment-header">
                                    <strong class="comment-author">${comment.author}</strong>
                                </div>
                                <p class="comment-text">${comment.text}</p>
                            </div>
                        </div>
                    </#list>
                </div>
            <#else>
                <p class="no-comments">No comments yet. Be the first to comment!</p>
            </#if>

            <div class="comment-form-wrapper">
                <h4 class="comment-form-title">Leave a Comment</h4>
                <form action="/post/${post.id}/comment" method="post" class="comment-form">
                    <div class="form-row">
                        <input name="author" placeholder="Your name" required>
                    </div>
                    <div class="form-row">
                        <textarea name="text" rows="5" placeholder="Share your thoughts..."></textarea>
                    </div>
                    <button type="submit" class="btn-primary">Post Comment</button>
                </form>
            </div>
        </div>
    </section>

</@layout>
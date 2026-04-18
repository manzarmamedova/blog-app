<#include "layout.ftlh">

<@layout title="Home">

    <section class="hero">
        <div class="hero-inner">
            <div class="hero-badge">Developer Blog</div>
            <h1 class="hero-title">Thoughts, Ideas &amp; Tutorials</h1>
            <p class="hero-sub">Articles about Java, Spring Boot, and modern web development.</p>
            <div class="hero-actions">
                <a href="/admin/create" class="btn-primary">Write a Post</a>
                <a href="#posts" class="btn-ghost">Browse Posts</a>
            </div>
        </div>
    </section>

    <#if successMessage??>
        <div class="flash-success">
            <span>✓</span> ${successMessage}
        </div>
    </#if>

    <div class="main-layout" id="posts">
        <main class="post-section">
            <div class="section-header">
                <h2 class="section-title">All Posts</h2>
                <span class="post-count">${(posts![])?size} articles</span>
            </div>

            <#if (posts![])?has_content>
                <div class="post-list">
                    <#list (posts![]) as post>
                        <article class="post-card">
                            <div class="post-card-inner">
                                <div class="post-card-meta">
                                    <span class="post-category">Article</span>
                                    <span class="post-date">${post.formattedDate}</span>
                                </div>
                                <h3 class="post-card-title">
                                    <a href="/post/${post.id}">${post.title}</a>
                                </h3>
                                <p class="post-card-excerpt">
                                    <#if (post.content?length > 160)>
                                        ${post.content?substring(0, 160)}...
                                    <#else>
                                        ${post.content}
                                    </#if>
                                </p>
                                <div class="post-card-footer">
                                    <div class="post-author">
                                        <div class="author-avatar">A</div>
                                        <div>
                                            <div class="author-name">Admin</div>
                                            <div class="author-meta">${post.comments?size} comments</div>
                                        </div>
                                    </div>
                                    <div class="post-card-actions">
                                        <a href="/post/${post.id}" class="btn-read">Read →</a>
                                        <a href="/admin/edit/${post.id}" class="btn-icon" title="Edit">✏</a>
                                        <form action="/admin/delete/${post.id}" method="post" style="display:inline">
                                            <button type="submit"
                                                    class="btn-icon danger"
                                                    onclick="return confirm('Delete this post?')"
                                                    title="Delete">✕</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </article>
                    </#list>
                </div>
            <#else>
                <div class="empty-state">
                    <div class="empty-icon">✍</div>
                    <h3>No posts yet</h3>
                    <p>Be the first to share your thoughts.</p>
                    <a href="/admin/create" class="btn-primary">Write First Post</a>
                </div>
            </#if>
        </main>

        <aside class="sidebar">
            <div class="sidebar-card stats-card">
                <h4 class="sidebar-title">Stats</h4>
                <div class="stats-row">
                    <div class="stat-item">
                        <div class="stat-number">${(posts![])?size}</div>
                        <div class="stat-label">Posts</div>
                    </div>
                    <div class="stat-divider"></div>
                    <div class="stat-item">
                        <div class="stat-number">
                            <#assign totalComments = 0>
                            <#list (posts![]) as post>
                                <#assign totalComments = totalComments + post.comments?size>
                            </#list>
                            ${totalComments}
                        </div>
                        <div class="stat-label">Comments</div>
                    </div>
                </div>
            </div>

            <div class="sidebar-card">
                <h4 class="sidebar-title">Recent Posts</h4>
                <#if (posts![])?has_content>
                    <ul class="recent-list">
                        <#list (posts![])?reverse as post>
                            <#if post?index < 5>
                                <li class="recent-item">
                                    <a href="/post/${post.id}" class="recent-link">${post.title}</a>
                                    <span class="recent-date">${post.shortDate}</span>
                                </li>
                            </#if>
                        </#list>
                    </ul>
                <#else>
                    <p class="sidebar-empty">No posts yet.</p>
                </#if>
            </div>

            <div class="sidebar-card about-card">
                <h4 class="sidebar-title">About</h4>
                <div class="about-avatar">A</div>
                <p class="about-text">A developer blog sharing knowledge about Java, Spring Boot, and web development.</p>
                <a href="/about" class="btn-outline full-width">Learn More</a>
            </div>

            <div class="sidebar-card">
                <a href="/admin/create" class="btn-primary full-width">+ Write New Post</a>
            </div>
        </aside>
    </div>

</@layout>
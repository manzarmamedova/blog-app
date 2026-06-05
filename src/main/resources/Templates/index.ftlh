<#include "layout.ftlh">

<@layout title="Home">

    <section class="hero">
        <div class="hero-inner">
            <div class="hero-badge">${springMacroRequestContext.getMessage("home.hero.badge")}</div>
            <h1 class="hero-title">${springMacroRequestContext.getMessage("home.hero.title")}</h1>
            <p class="hero-sub">${springMacroRequestContext.getMessage("home.hero.sub")}</p>
            <div class="hero-actions">
                <a href="/admin/create" class="btn-primary">${springMacroRequestContext.getMessage("home.hero.write")}</a>
                <a href="#posts" class="btn-ghost">${springMacroRequestContext.getMessage("home.hero.browse")}</a>
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
                <h2 class="section-title">${springMacroRequestContext.getMessage("home.posts.title")}</h2>
                <span class="post-count">${(posts![])?size} ${springMacroRequestContext.getMessage("common.article")}</span>
            </div>

            <#if (posts![])?has_content>
                <div class="post-list">
                    <#list (posts![]) as post>
                        <article class="post-card">
                            <div class="post-card-inner">
                                <div class="post-card-meta">
                                    <span class="post-category">${springMacroRequestContext.getMessage("common.article")}</span>
                                    <span class="post-date">${post.formattedDate}</span>
                                </div>
                                <h3 class="post-card-title">
                                    <a href="/post/${post.id}">${post.title}</a>
                                </h3>
                                <p class="post-card-excerpt">

                                    <#if ((post.content!"")?length > 160)>

                                        ${post.content?substring(0, 160)}...
                                    <#else>
                                        ${post.content}
                                    </#if>
                                </p>
                                <div class="post-card-footer">
                                    <div class="post-author">
                                        <div class="author-avatar">A</div>
                                        <div>
                                            <div class="author-name">${springMacroRequestContext.getMessage("common.author")}</div>
                                            <div class="author-meta">${post.comments?size} ${springMacroRequestContext.getMessage("home.sidebar.comments")}</div>
                                        </div>
                                    </div>
                                    <div class="post-card-actions">
                                        <a href="/post/${post.id}" class="btn-read">${springMacroRequestContext.getMessage("home.posts.readMore")} →</a>
                                        <a href="/admin/edit/${post.id}" class="btn-icon" title="Edit">✏</a>
                                        <form action="/admin/delete/${post.id}" method="post" style="display:inline">
                                            <button type="submit"
                                                    class="btn-icon danger"
                                                    onclick="return confirm('${springMacroRequestContext.getMessage("home.confirm.delete")}')"
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
                    <h3>${springMacroRequestContext.getMessage("home.posts.noPost")}</h3>
                    <p>${springMacroRequestContext.getMessage("home.posts.noPost.sub")}</p>
                    <a href="/admin/create" class="btn-primary">${springMacroRequestContext.getMessage("home.posts.writeFirst")}</a>
                </div>
            </#if>
        </main>

        <aside class="sidebar">
            <div class="sidebar-card stats-card">
                <h4 class="sidebar-title">${springMacroRequestContext.getMessage("home.sidebar.stats")}</h4>
                <div class="stats-row">
                    <div class="stat-item">
                        <div class="stat-number">${(posts![])?size}</div>
                        <div class="stat-label">${springMacroRequestContext.getMessage("home.sidebar.posts")}</div>
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
                        <div class="stat-label">${springMacroRequestContext.getMessage("home.sidebar.comments")}</div>
                    </div>
                </div>
            </div>

            <div class="sidebar-card">
                <h4 class="sidebar-title">${springMacroRequestContext.getMessage("home.sidebar.recentPosts")}</h4>
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
                    <p class="sidebar-empty">${springMacroRequestContext.getMessage("home.posts.noPost")}.</p>
                </#if>
            </div>

            <div class="sidebar-card about-card">
                <h4 class="sidebar-title">${springMacroRequestContext.getMessage("home.sidebar.about")}</h4>
                <div class="about-avatar">A</div>
                <p class="about-text">${springMacroRequestContext.getMessage("home.sidebar.aboutText")}</p>
                <a href="/about" class="btn-outline full-width">${springMacroRequestContext.getMessage("home.sidebar.learnMore")}</a>
            </div>

            <div class="sidebar-card">
                <a href="/admin/create" class="btn-primary full-width">${springMacroRequestContext.getMessage("home.sidebar.writeNew")}</a>
            </div>
        </aside>
    </div>

</@layout>

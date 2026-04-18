<#macro layout title="Blog">
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>${title} | DevBlog</title>
        <link rel="stylesheet" href="/style.css">
    </head>
    <body>

    <header class="site-header">
        <div class="header-inner">
            <a href="/" class="brand">
                <span class="brand-icon"></span>
                DevBlog
            </a>
            <nav class="nav-links">
                <a href="/">Home</a>
                <a href="/about">About</a>
                <a href="/admin/create" class="nav-btn">+ New Post</a>
            </nav>
        </div>
    </header>

    <div class="page-body">
        <#nested>
    </div>

    <footer class="site-footer">
        <div class="footer-inner">
            <div class="footer-brand">
                <span class="brand-icon small"></span>
                DevBlog
            </div>
            <p class="footer-text">A blog about software development, Java, and Spring Boot.</p>
            <div class="footer-links">
                <a href="/">Home</a>
                <a href="/about">About</a>
                <a href="/admin/create">Write</a>
                <a href="/api/posts">API</a>
            </div>
            <p class="footer-copy">© 2026 DevBlog. Built with Spring Boot & FreeMarker.</p>
        </div>
    </footer>

    </body>
    </html>
</#macro>
```
<nav>
    <a href="/">${springMacroRequestContext.getMessage("nav.home")}</a>
    <a href="/about">${springMacroRequestContext.getMessage("nav.about")}</a>

    <#if user??>
        <a href="/admin/create">${springMacroRequestContext.getMessage("nav.newPost")}</a>
        <a href="/logout">${springMacroRequestContext.getMessage("nav.logout")}</a>
    <#else>
        <a href="/login">${springMacroRequestContext.getMessage("nav.login")}</a>
        <a href="/register">${springMacroRequestContext.getMessage("nav.register")}</a>
    </#if>

    <div class="lang-switcher">
        <a href="?lang=en">EN</a>
        <a href="?lang=tr">TR</a>
        <a href="?lang=ka">KA</a>
    </div>
</nav>
boyle oldu bashtan sona
```
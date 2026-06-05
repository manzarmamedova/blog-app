<!DOCTYPE html>
<html>
<head>
    <title>${springMacroRequestContext.getMessage("register.title")}</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body class="auth-page">

<div class="auth-center">
    <div class="auth-card">

        <h1 class="auth-title">${springMacroRequestContext.getMessage("register.title")}</h1>
        <p class="auth-sub">${springMacroRequestContext.getMessage("register.sub")}</p>

        <#if error??>
            <div class="auth-error">${error}</div>
        </#if>

        <form method="post" action="/register" class="auth-form">
            <input type="text" name="username"
                   placeholder="${springMacroRequestContext.getMessage("register.username")}" required>
            <input type="password" name="password"
                   placeholder="${springMacroRequestContext.getMessage("register.password")}" required>
            <button type="submit">${springMacroRequestContext.getMessage("register.submit")}</button>
        </form>

        <div class="auth-footer">
            ${springMacroRequestContext.getMessage("register.hasAccount")}
            <a href="/login">${springMacroRequestContext.getMessage("register.login")}</a>
        </div>

        <div class="lang-switcher">
            <a href="?lang=en">EN</a>
            <a href="?lang=tr">TR</a>
            <a href="?lang=ka">KA</a>
        </div>

    </div>
</div>

</body>
</html>

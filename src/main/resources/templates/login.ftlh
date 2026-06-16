<!DOCTYPE html>
<html>

    <head>
        <title>Login</title>
        <link rel="stylesheet" href="/css/style.css">
    </head>

<body class="auth-page">

<div class="auth-center">

    <div class="auth-card">

        <h1 class="auth-title">Welcome back</h1>
        <p class="auth-sub">Sign in to continue</p>

        <#if error??>
            <div class="auth-error">${error}</div>
        </#if>

        <form method="post" action="/login" class="auth-form">

            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>

            <button type="submit">Login</button>

        </form>

        <div class="auth-footer">
            No account?
            <a href="/register">Create one</a>
        </div>

    </div>

</div>

</body>
</html>
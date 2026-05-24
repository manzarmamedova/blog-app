<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="/css/style.css">
</head>

<body class="auth-page">

<div class="auth-center">

    <div class="auth-card">

        <h1 class="auth-title">Create account</h1>
        <p class="auth-sub">Join the platform</p>

        <#if error??>
            <div class="auth-error">${error}</div>
        </#if>

        <form method="post" action="/register" class="auth-form">

            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>

            <button type="submit">Register</button>

        </form>

        <div class="auth-footer">
            Already have account?
            <a href="/login">Login</a>
        </div>

    </div>

</div>

</body>
</html>